
class Item{
   
    constructor (index,name,count,price)
    {
        this.index=Number(index);
        this.name=name;
        this.count=Number(count);
        this.price=Number(price);
        this.sum=Number((count*price).toFixed(2));      
    }
    przelicz()
    {
        this.sum=Number((count*price).toFixed(2)); 
    }      
}
let invoice;
let ParagonItems=[];

loadpage();
function loadpage()
{
     
    console.log(localStorage)
    if(localStorage.ParagonItems)
    {
        ParagonItems=JSON.parse(localStorage.ParagonItems)
       
    }
    dodajdoParagonu();
}
function updateIndex(ind)
{
    console.log(ParagonItems)
    for(var x=ind;x<ParagonItems.length;x++)
    {
        
        console.log(ParagonItems[x].index=ParagonItems[x].index-1);
        
    }
}
function up(r)
{
    var i = r.parentNode.parentNode.rowIndex-1;
    if(i>0){       
        var tmp=ParagonItems[i]       
        ParagonItems[i].index=ParagonItems[i-1].index;
        ParagonItems[i]=ParagonItems[i-1];
        ParagonItems[i-1]=tmp;
        ParagonItems[i].index++;
        localStorage.ParagonItems=JSON.stringify(ParagonItems);  
        console.log(ParagonItems);   
        razem();
        dodajdoParagonu();
    }   
       
   
}
function down(r)
{
    var i = r.parentNode.parentNode.rowIndex-1;
    if(i<ParagonItems.length-1){       
        var tmp=ParagonItems[i]       
        ParagonItems[i].index=ParagonItems[i+1].index;
        ParagonItems[i]=ParagonItems[i+1];
        ParagonItems[i+1]=tmp;
        ParagonItems[i].index--;  
        localStorage.ParagonItems=JSON.stringify(ParagonItems);  
        console.log(ParagonItems);   
        razem();
        dodajdoParagonu();     
    }   
       
   
}
function dodajdoParagonu()
{
    $('main').data.reload;
        let table_body = '<table id=Paragon>';
        table_body += '<thead><tr>'
        table_body += '<th class="lp">LP</th>';
        table_body += '<th class="nazwa">Nazwa</th>';
        table_body += '<th>ILOŚĆ</th>';
        table_body += '<th>CENA</th>';
        table_body += '<th>SUMA</th>';       
        table_body += '<th>Edit</th>';
        table_body += '<th>Remove</th>';
        table_body += '<th>Up</th>';
        table_body += '<th>Down</th>';
        table_body += '</tr></thead>';  
    if(ParagonItems.length>0)
    {       
        table_body += '<tbody>'
    for(var i=0;i<ParagonItems.length;i++)
    {
        var temp = ParagonItems[i];
        table_body += '<tr>'
        table_body += '<td>'+temp.index+'</td>';
        table_body += '<td>'+temp.name+'</td>';
        table_body += '<td>'+temp.count+'</td>';
        table_body += '<td>'+temp.price+'</td>';
        table_body += '<td>'+temp.sum+' zł</td>';       
        table_body += '<td><button class=edit onclick=edit(this)>Edytuj</button></td>';
        table_body += '<td><button class=rm onclick=usun(this)>Usuń</button></td>';
        table_body += '<td><button class=up onclick=up(this)>up</button></td>';
        table_body += '<td><button class=up onclick=down(this)>dwon</button></td>';
        table_body += '</tr>';                          
    }
        table_body += '<tr>';
        table_body += '<td colspan="8" class="razem">RAZEM</td>';
        table_body += '<td class="razem" id=Razem></td>';
        table_body += '</tr>';
        table_body += '</tbody>'
}
table_body += '</table>'
$('main').html(table_body);
    razem();
}

function addItem()
{
    //var table = document.getElementById("Paragon");   
    var temp=new Item(ParagonItems.length+1,document.getElementById("Nazwa").value,
    document.getElementById("Ilość").value,document.getElementById("Cena").value)
    
    ParagonItems.push(temp);
    
    var cena = $("#Cena").val()
    //$('#Paragon tr:last')
    //    .before("<tr class='data'><td>"+temp.index+"</td><td>"+temp.name+"</td><td>"+temp.count+"</td><td>"+temp.price+"</td><td>"+temp.sum+" zł</td><td><button class='rm' onclick='usun(this)'>Usuń</button></td><td><button class='edit' onclick='edit()'>Edytuj</button></td></tr>");
    dodajdoParagonu();
    formClear();
    razem();  
    localStorage.ParagonItems=JSON.stringify(ParagonItems);
    
    
}
function usun(r)
{      
    var i = r.parentNode.parentNode.rowIndex;  
    console.log(i)
    document.getElementById("Paragon").deleteRow(i);          
    ParagonItems.splice(i-1,1); 
    updateIndex(i-1);   
    localStorage.ParagonItems=JSON.stringify(ParagonItems);  
    console.log(ParagonItems);   
    razem();
    dodajdoParagonu();
}

function formClear(){
    $('#Nazwa').val("");
    $('#Ilość').val("");
    $('#Cena').val("");
}
function razem()
{
    $("#Razem").empty();
    if(ParagonItems.length===0)$('#Razem').append('0 zł')
    else {var temp=0;
        for(var i=0;i<ParagonItems.length;i++)
        {
            temp=temp+ParagonItems[i].sum;
        } 
        $("#Razem").append(temp+" zł");
}
}

function edit(r)
{
    var i = r.parentNode.parentNode.rowIndex;
    var row = document.getElementById('Paragon').rows[i];
    console.log(row);
    row.cells[1].innerHTML="<input type='text' size='5' value="+ParagonItems[i-1].name+"></input>" 
    row.cells[2].innerHTML="<input type='text' size='5' value="+ParagonItems[i-1].count+"></input>"
    row.cells[3].innerHTML="<input type='text' size='5' value="+ParagonItems[i-1].price+"></input>" 
    row.cells[5].innerHTML="<button  onclick=update("+i+")>Save</input>"         
      
}
function update(i)
{
    var ind = Number(i);
    var row = document.getElementById('Paragon').rows[i];    
    console.log(ParagonItems[ind-1].name=row.cells[1]);
    console.log(ParagonItems[ind-1].count=row.cells[2].value);
    console.log(ParagonItems[ind-1].price=row.cells[3].value);
    ParagonItems[ind-1].przelicz;
    localStorage.ParagonItems=JSON.stringify(ParagonItems);  
       
    razem();
    dodajdoParagonu();
}



