 var textView_1,textView_2,textView_3,textView_4;
 var table ;
 document.addEventListener("DOMContentLoaded", run);
 function run()
 {
	textView_1 = document.getElementById("text_firstfild");
	textView_2 = document.getElementById("text_secondfild");
	textView_3 = document.getElementById("text_therdtfild");
	textView_4 = document.getElementById("text_fourtfild");
	table= document.getElementById("table");
 }
	function clickBtnStart() 
	{	
	var row = table.insertRow(0);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	cell1.innerHTML = textView_1.value;
	cell2.innerHTML = textView_2.value;
	cell3.innerHTML = textView_3.value;
	cell4.innerHTML = textView_4.value;
	}
	function clickBtnMid() 
	{	
	var tableLenght = table.rows.length;		
	var row = table.insertRow(tableLenght/2);

	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	cell1.innerHTML = textView_1.value;
	cell2.innerHTML = textView_2.value;
	cell3.innerHTML = textView_3.value;
	cell4.innerHTML = textView_4.value;
	}
	function clickBtnEnd() 
	{
	var tableLenght = table.rows.length;		
	var row = table.insertRow(tableLenght);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	cell1.innerHTML = textView_1.value;
	cell2.innerHTML = textView_2.value;
	cell3.innerHTML = textView_3.value;
	cell4.innerHTML = textView_4.value;
	}

	function clickBtnDelStart() 
	{	
	table.deleteRow(0);
	}
	function clickBtnDelMid() 
	{	
	var tableLenght = table.rows.length;		
	table.deleteRow(tableLenght/2);
	}
	function clickBtnDelEnd() 
	{
	var tableLenght = table.rows.length-1;		
	table.deleteRow(tableLenght);
	}
	
function sendPost(ths) 
{

         var tr = ths.parentNode.parentNode,
         code = tr.getElementsByTagName("td")[0].innerHTML,
         name = tr.getElementsByTagName("td")[1].innerHTML.replace("<b>", "").replace("</b>", ""),
         review = tr.getElementsByTagName("td")[3].childNodes[0].value;
    alert(code+"\n"+name+"\n"+review);
}
