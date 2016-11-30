function culc(){
   var result =0;
   var stringFirstNumb = document.getElementById("firstNumb").value;
   var charOperation = document.getElementById("charOperation").value;    
   var stringSecondNumb = document.getElementById("secondNumb").value;
   var firstNumb= parseInt(stringFirstNumb, 10);
   var secondNumb= parseInt(stringSecondNumb, 10);
   if(charOperation=='+')
   {
      result = firstNumb+secondNumb;
   }
   if(charOperation=='-')
   {
	  result = firstNumb - secondNumb;
   }
   if(charOperation=='*')
   {
	  result = firstNumb * secondNumb;
   }
   if(charOperation=='/')
   {
	  result = firstNumb / secondNumb;
   }
   document.getElementById("resultCulc").value=result;
}
  