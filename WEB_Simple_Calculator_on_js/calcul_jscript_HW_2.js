var firstStringNumber="";
var charOperation='';
var secondStringNumber="";
function setnumb(numb)
{
	var result=0;
	 if("string" ==typeof(numb)||"number" ==typeof(numb))
     {
	 result = numb;
     }
	else if(charOperation=='')
	{
	   firstStringNumber+=numb.value;
	   document.getElementById("expression").value=firstStringNumber;
       result=firstStringNumber; 
	}
	else
	{
	   secondStringNumber+=numb.value;
	   document.getElementById("expression").value=secondStringNumber;
	   result=secondStringNumber; 
	}
	return result;
}

function operation(operationValue)
{	 
     var result='';
     if("string" ==typeof(operationValue))
     {
	 charOperation=operationValue;
	 result= charOperation;
     }
	else if(firstStringNumber!="")
	{
     charOperation=operationValue.value;
	 result= charOperation;
     document.getElementById("expression").value=charOperation;
	}
	else{
     	var hid = document.getElementById("hidd").value=operationValue.value;
	document.getElementById("expression").value=hid;
	}
	return result;
}
function equal(fir,sec,op)//firstStringNumber,secondStringNumber,charOperation)
{
	var hid = document.getElementById("hidd").value="=";
	document.getElementById("expression").value=hid;
   var result =0;
   var firstNumb= 0;
   var secondNumb=0;
   if(firstStringNumber!=""&&secondStringNumber!="")
   {
   firstNumb= parseInt(firstStringNumber, 10);
   secondNumb= parseInt(secondStringNumber, 10);  
   result = calc (firstNumb,secondNumb,charOperation)
   document.getElementById("expression").value=result;
   }
   else
   {
	 result = calc (fir,sec,op)  
   }
  firstStringNumber="";
  charOperation='';
  secondStringNumber="";
  return result;
}
function calc (a,b,op)
{
    var ret = 0;
    switch(op)
	{
	case '+': ret=a+b;break;
	case '-': ret=a-b;break;
	case '*': ret=a*b;break;
	case '/': ret=a/b;break;
	}
	return ret;
} 