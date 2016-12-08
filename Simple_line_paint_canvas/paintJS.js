window.onload = function()
{	
    var canvas, ctx, flag = false,
        prevX = 0,
        currX = 0,
        prevY = 0,
        currY = 0,
        dot_flag = false;	
	   function init() 
	   {
			canvas = document.getElementById('canvasID');
			ctx = canvas.getContext('2d');
			canvas.addEventListener("mousemove", function (event)
			{
				//document.getElementById('xy').innerHTML = "x = " + e.pageX + ", y = " + e.pageY;
				findxy('move',event)
			});
			canvas.addEventListener("mousedown", function (event) 
			{
				findxy('down', event)
			});
			canvas.addEventListener("mouseup", function (event) 
			{
				findxy('up', event)
			});
			canvas.addEventListener("mouseout", function (event) 
			{
				findxy('out',event)
			});
		}
   
	function findxy(res, event)
	{
        if (res == 'down') 
		{
            prevX = currX;
            prevY = currY;
            currX = event.clientX - canvas.offsetLeft;
            currY = event.clientY - canvas.offsetTop;
    
            flag = true;
            dot_flag = true;
            if (dot_flag) 
			{
                ctx.beginPath();
               
                ctx.fillRect(currX, currY, 2, 2);
                ctx.closePath();
                dot_flag = false;
            }
        }
		
        if (res == 'up' || res == "out") 
		{
            flag = false;
        }
		
        if (res == 'move') 
		{
            if (flag) 
			{
                prevX = currX;
                prevY = currY;
                currX = event.clientX - canvas.offsetLeft;
                currY = event.clientY - canvas.offsetTop;
                drawing();
            }
        }
		
    }
	function drawing()
	{
        ctx.beginPath();
        ctx.moveTo(prevX, prevY);
        ctx.lineTo(currX, currY);
        ctx.stroke();
    }
    init();
}