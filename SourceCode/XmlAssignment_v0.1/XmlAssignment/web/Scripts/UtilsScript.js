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
function loadXMLString(txt)
{
if (window.DOMParser)
  {
  parser=new DOMParser();
  x=parser.parseFromString(txt,"text/xml");
  }
else // Internet Explorer
  {
  x=new ActiveXObject("Microsoft.XMLDOM");
  x.async=false;
  x.loadXML(txt);
  }
return x;
}
function XMLToString(oXML) {   if (window.ActiveXObject) {     return oXML.xml;   } else {     return (new XMLSerializer()).serializeToString(oXML);   } }


