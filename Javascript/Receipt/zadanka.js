class Receipt {
    constructor(table=[]) {
        this.table_of_records = table;
        this.table_body = document.getElementsByTagName("tbody")[0];
        this.table_tr = document.getElementsByTagName("tr");
        this.inputs = document.getElementsByTagName("input");
        this.name_field = this.inputs[0];
        this.number_field = this.inputs[1];
        this.price_field = this.inputs[2];
        this.inputs[3].setAttribute("onclick", "receipt.addRecord()");
        this.total = 0;
    }

    addRecord() {
        let name = this.name_field.value;
        let number = this.number_field.value;
        let price = this.price_field.value;
        number = number.replace(",", ".");
        price = price.replace(",", ".");
        if (this.validate(name, number, price)) {
            let new_record = new Record(name, number, price);
            this.addToReceipt(new_record);

            this.name_field.value = '';
            this.number_field.value = '';
            this.price_field.value = '';
        }
    }

    removeRecord(index) {
        this.table_of_records.splice(index, 1);
        this.update();
    }

    editRecord(index) {
        
        let temp = this.table_tr[index+1];
        let name = document.createElement("td");
        name.appendChild(document.createElement("input"));
        name.childNodes[0].type="text";
        name.childNodes[0].size="2";
        name.childNodes[0].value=this.table_of_records[index].name;
        let number = document.createElement("td");
        number.appendChild(document.createElement("input"));
        number.childNodes[0].type="text";
        number.childNodes[0].size="2";
        number.childNodes[0].value=this.table_of_records[index].number;
        let price = document.createElement("td");
        price.appendChild(document.createElement("input"));
        price.childNodes[0].type="text";
        price.childNodes[0].size="2";
        price.childNodes[0].value=this.table_of_records[index].price;
        let submit = document.createElement("td");
        submit.appendChild(document.createElement("input"));
        submit.childNodes[0].type="button";
        submit.childNodes[0].value="Zatwierdź";
        submit.childNodes[0].setAttribute("onclick", "receipt.editRecordConfirmation(" + index + ")");
        temp.replaceChild(name,temp.childNodes[1]);
        temp.replaceChild(number,temp.childNodes[2]);
        temp.replaceChild(price,temp.childNodes[3]);
        temp.replaceChild(submit,temp.childNodes[5]);
        
        document.getElementById("input_name").disabled = true;
        document.getElementById("input_number").disabled = true;
        document.getElementById("input_price").disabled = true;
        document.getElementById("input_add").disabled = true;

        for (let i=1; i<this.table_tr.length; i++) {
            temp = this.table_tr[i];
            if (temp.childNodes[5].childNodes[0].value == "Edytuj") temp.childNodes[5].childNodes[0].disabled = true;
            temp.childNodes[6].childNodes[0].disabled = true;
            temp.childNodes[6].childNodes[1].disabled = true;
            temp.childNodes[7].childNodes[0].disabled = true;
        }

    }

    editRecordConfirmation(index) {
        let temp = this.table_tr[index+1];
        //let record = this.table_of_records[index];
        let name = temp.childNodes[1].childNodes[0].value;
        let number = temp.childNodes[2].childNodes[0].value;
        let price = temp.childNodes[3].childNodes[0].value;
        if (!this.validate(name, number, price)) {
            this.editRecord(index);
        }
        let record = new Record(name, number, price);
        //record.name = name;
        //record.number = number;
        //record.price = price;
        //record.total = number * price;
        this.table_of_records[index] = record;

        document.getElementById("input_name").disabled = false;
        document.getElementById("input_number").disabled = false;
        document.getElementById("input_price").disabled = false;
        document.getElementById("input_add").disabled = false;

        this.update();
    }

    moveUp(i) {
        let temp = this.table_of_records[i - 1];
        this.table_of_records[i - 1] = this.table_of_records[i];
        this.table_of_records[i] = temp;
        this.update();
    }

    moveDown(i) {
        let temp = this.table_of_records[i + 1];
        this.table_of_records[i + 1] = this.table_of_records[i];
        this.table_of_records[i] = temp;
        this.update();
    }

    validate(name, number, price) {
        if (!this.validateName(name)) {
            alert("Name field is empty");
            return false;
        }
        if (!this.validateIsFloat(number)) {
            alert("Wrong type of input");
            return false;
        }
        if (!this.validateIsFloat(price)) {
            alert("Wrong type of input");
            return false;
        }
        return true;
    }

    validateIsFloat(number) {
        if (isNaN(number))
        {
            return false;
        }
        if (number.length == 0) {          
            return false;
        }
        return true;
    }

    validateName(name) {
        if (name.length == 0) {
            return false;
        }
        return true;
    }

    addToReceipt(record) {
        this.table_of_records.push(record);
        this.update();
    }

    calculateTotal() {
        this.total = 0;
        for (let record of this.table_of_records) {
            this.total += parseFloat(record.total);
        }
    }

    update() {
        this.table_body.innerHTML = "";
        for (let record_index in this.table_of_records) {
            let element = document.createElement("tr");
            let children = [];
            let delete_button = document.createElement("input");
            delete_button.type = "button";
            delete_button.setAttribute("onclick", "receipt.removeRecord(" + record_index + ")");
            delete_button.value = "Usuń";
            let up_button = document.createElement("input");
            up_button.type = "button";
            up_button.setAttribute("onclick", "receipt.moveUp(" + record_index + ")");
            up_button.value = "Przesuń w górę";
            if (parseInt(record_index) === 0)
                up_button.disabled = true;
            let down_button = document.createElement("input");
            down_button.type = "button";
            down_button.setAttribute("onclick", "receipt.moveDown(" + record_index + ")");
            down_button.value = "Przesuń w dół";
            if (parseInt(record_index) === this.table_of_records.length - 1)
                down_button.disabled = true;
            let edit_button = document.createElement("input");
            edit_button.type = "button";
            edit_button.setAttribute("onclick", "receipt.editRecord(" + record_index + ")");
            edit_button.value = "Edytuj";
            for (let i = 0; i < 8; i++) {
                children[i] = document.createElement("td");
            }
            children[0].appendChild(document.createTextNode((parseInt(record_index) + 1).toString()));
            children[0].classList.add("lp");
            children[1].appendChild(document.createTextNode(this.table_of_records[record_index].name));
            children[1].classList.add("nazwa");
            children[2].appendChild(document.createTextNode(this.table_of_records[record_index].number));
            children[3].appendChild(document.createTextNode(this.table_of_records[record_index].price));
            children[4].appendChild(document.createTextNode(this.table_of_records[record_index].total));
            children[5].appendChild(edit_button);
            children[6].appendChild(up_button);
            children[6].appendChild(down_button);
            children[7].appendChild(delete_button);
            for (let child of children) {
                element.appendChild(child);
            }
            this.table_body.appendChild(element);
        }
        this.calculateTotal();
        let total_row = document.createElement("tr");
        let total = document.createElement("td");
        total.classList.add("razem");
        total.setAttribute("colspan", "4");
        total.appendChild(document.createTextNode("RAZEM"));
        let total_value = document.createElement("td");
        total_value.classList.add("razem");
        total_value.appendChild(document.createTextNode(this.total));
        total_row.appendChild(total);
        total_row.appendChild(total_value);
        this.table_body.appendChild(total_row);
        localStorage.table = JSON.stringify(this.table_of_records);
    }
}

class Record {
    constructor(name, number, price) {
        this.name = name;
        this.number = parseFloat(number).toFixed(2);
        this.price = parseFloat(price).toFixed(2);
        this.total = parseFloat(this.calculateTotal()).toFixed(2);
    }

    calculateTotal() {
        return this.number * this.price;
    }

    overwrite(name, number, price) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.total = this.calculateTotal()
    }
}

// localStorage.clear();
let receipt;

if (localStorage.table === undefined) {
    receipt = new Receipt();
}
else {
    receipt = new Receipt(JSON.parse(localStorage.table));
    receipt.update();
}
