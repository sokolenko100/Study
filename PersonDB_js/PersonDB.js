document.addEventListener("DOMContentLoaded", run);
var textView_1, textView_2, textView_3, textView_4;
var table;
var personsArray = [];
var typeFile;
var load;
var xml = "xml";
var yaml = "yaml";
var csv = "csv";
var clear = "clear";
var json = "json";
function Person(id, fname, lname, age)
{
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.age = age;
}
function run() 
{
	typeFile = document.getElementById('box');
    textView_1 = document.getElementById("text_firstfild");
    textView_2 = document.getElementById("text_secondfild");
    textView_3 = document.getElementById("text_therdtfild");
    textView_4 = document.getElementById("text_fourtfild");
    table = document.getElementById("table");
    for (var i = 1; i < table.rows.length+1; i++)
    {
        var p = new Person(i , "fname_" + i, "lname_" + i, 5 * i);
        table.rows[i].cells[0].innerHTML = p.id;
        table.rows[i].cells[1].innerHTML = p.fname;
        table.rows[i].cells[2].innerHTML = p.lname;
        table.rows[i].cells[3].innerHTML = p.age;
        personsArray.push(p);
    }
}
function clearTable()
{
    while (table.rows.length  >1)
    {
        table.deleteRow(1);
    }
}

function clickBtn(x) {
    var row;
    var tableLenght = table.rows.length;
    if (x == "addStart") {
        row = table.insertRow(0);
    }
    if (x == "addMid") {
        row = table.insertRow(tableLenght / 2);
    }
    if (x == "addEnd") {
        row = table.insertRow(tableLenght);
    }
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    cell1.innerHTML = textView_1.value;
    cell2.innerHTML = textView_2.value;
    cell3.innerHTML = textView_3.value;
    cell4.innerHTML = textView_4.value;
    var p = new Person(textView_1.value, textView_2.value, textView_3.value, textView_4.value);
    personsArray.push(p);
}
function load()
{
    var returnObj;
    if (json == typeFile.value)
    {
        returnObj = JSON.parse(localStorage.getItem(json))
		clearTable();
    }
    if (xml == typeFile.value)
    {
		clearTable();
        var xmlString = localStorage.getItem(xml);
        if (xmlString)
		{
            var oParser = new DOMParser();
            var oDOM = oParser.parseFromString(xmlString, "text/xml");
            table.innerHTML = oDOM.documentElement.innerHTML;
			return;
        }
    }
    if (csv == typeFile.value)
    {
		clearTable();
        returnObj = fromCSV(localStorage.getItem(csv));
        for (var i = 0; i < returnObj.length-1; i++) {
            var row = table.insertRow();
            row.insertCell(0).innerHTML = returnObj[i][0];
            row.insertCell(1).innerHTML = returnObj[i][1];
            row.insertCell(2).innerHTML = returnObj[i][2];
            row.insertCell(3).innerHTML = returnObj[i][3];
        }
        return;
    }
    if (yaml == typeFile.value)
    {
		clearTable();
        yamlString = localStorage.getItem(yaml);
        returnObj = YAML.parse(yamlString);
    }
    for (var i = 0; i < returnObj.length; i++)
    {
        var row = table.insertRow();
        row.insertCell(0).innerHTML = returnObj[i].id;
        var name = returnObj[i].name;
        row.insertCell(1).innerHTML = returnObj[i].fname;
        row.insertCell(2).innerHTML = returnObj[i].lname;
        row.insertCell(3).innerHTML = returnObj[i].age;;
    }
}
	function fromCSV(csv)
	{
	        var pp=[];
			var regex = "\n";
			var  Persons = csv.split(regex);
			for (var j = 1; j < Persons.length; j++) 
			{
		    	var Person =Persons[j].split(",");
		    	var p = setPerson(Person);
				pp.push(p);
			}
			return pp;
	}
	function setPerson ( Person)
	{
	    var p = [];
		var id =Person[0];
		var fname = Person[1];
		var lname = Person[2];
		var age = Person[3];
		p.push(id);
		p.push(fname);
		p.push(lname);
		p.push(age);
		return p;
	}
function serialization()
{
    if (typeFile.value == "json")
    {
        var serialObj = JSON.stringify(personsArray);
        localStorage.setItem(json, serialObj);
    }
    if (typeFile.value == "xml")
    {
        var serializer = new XMLSerializer();
        var serializerString = serializer.serializeToString(table);
        localStorage.setItem(xml, serializerString);
    }
    if (typeFile.value == "csv")
    {
       var serialObj = toCSV(personsArray);
       localStorage.setItem(csv, serialObj);
    }
    if (typeFile.value == "yaml")
    {
        var serialObj = YAML.stringify(personsArray);
        localStorage.setItem(yaml, serialObj);
    }
}
	function toCSV(pp)
	{		
		var res ="id,fname,lname,age"+"\n";
		for (var i=0; i<pp.length;i++) 
		{
		    var p = pp[i];
		    res += p.id + ",";
		    res += p.fname  + ",";
		    res += p.lname  + ",";
		    res += p.age + ",";
		    res += "\n";
		}
		return res;
	}
	function clickDel(x) 
	{
    if (x == "dellStart") {
        table.deleteRow(1);
    }
    if (x == "dellMid") {
        var tableLenght = table.rows.length;
        table.deleteRow(tableLenght - 1 / 2);
    }
    if (x == "dellEnd") {
        var tableLenght = table.rows.length - 1;
        table.deleteRow(tableLenght);
    }
	}