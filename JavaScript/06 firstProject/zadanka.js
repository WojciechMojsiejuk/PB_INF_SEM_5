class Receipt {
    constructor(table=[]) {
        this.table_of_records = table;
        this.table_body = document.getElementsByTagName("tbody")[0];
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
        let a = this.validateIsFloat(number);
        let b = this.validateIsFloat(price);
        if (a && b){
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

    validateIsFloat(number) {
        if (isNaN(number))
        {
            alert("Must input numbers");
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
            this.total += record.total;
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
            // children[5].appendChild(edit_button);
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
        this.number = number;
        this.price = price;
        this.total = this.calculateTotal()
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
