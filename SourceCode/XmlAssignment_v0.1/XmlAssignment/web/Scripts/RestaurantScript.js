/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var xmlDoc;

function addRow(tableId,cells){
    var tbl=document.getElementById(tableId);
    var newRow=tbl.insertRow(tbl.rows.length);
    var newCell;
    for (i = 0; i < cells.length; i++) {
        newCell=newRow.insertCell(newRow.cells.length);
        newCell.innerHTML=cells[i];
    }
    return newRow;
}

function saveNewRestaurant(){
    var tName=document.getElementById("txtName");
    var tLatitue=document.getElementById("txtLatitute");
    var tLongtitute=document.getElementById("txtLongtitute");
    var tAddress=document.getElementById("txtAddress");
    var tDescription=document.getElementById("txtDescription");
    var tPhoneNum=document.getElementById("txtPhoneNum");
    
    var data="action=RESTAURANT_ADD&name="+
    tName.value+"&latitute="+
    tLatitue.value+"&longtitute="+
    tLongtitute.value+ "&address="+
    tAddress.value+"&description="+
    tDescription.value+"&phone="+tPhoneNum.value;
    xmlhttp=getXmlHttpObj();
    xmlhttp.open("GET",contextPath+"/RestaurantController?"+data,false);
    xmlhttp.send();
    
    var errorXml=xmlhttp.responseXML;
    var errorContainer=document.getElementById("ErrorContainer");
    errorContainer.innerHTML="";
    
    if(errorXml){
        errorContainer.innerHTML=xmlhttp.responseXML.getElementsByTagName("error")[0].textContent.fontcolor("red");
    }else{
        var resString=xmlhttp.responseText;
        var containerElement=document.getElementById("RestaurantContainer");
        containerElement.innerHTML=resString;
    }
    
    
    
   
}

