/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function getXmlHttpObj(){
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xml=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xml=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xml;
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
    xmlDoc=xmlhttp.responseXML;
}

