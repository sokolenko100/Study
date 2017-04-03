		document.addEventListener("DOMContentLoaded", init);
		var svg = document.getElementById('svgPanel');
		var bound = svg.getBoundingClientRect();
		var svgns ="http://www.w3.org/2000/svg";
		var  flag = false, rectFlag = false,
		typeF;
       	currentX=0,
		currentY=0,
		prevX=0,
		prevY=0, 
		color = setColor(3);
		sizeLine =3;
		
		var figures = [];
		
		function PFigure(x0, y0, x1, y1, color,type, sizeLine)
		{
			this.type = type;
			this.x0 = x0;
			this.y0 = y0;
			this.x1 = x1;
			this.y1 = y1;
			this.color = color;
			this.sizeLine = sizeLine;

			this.draw = function()
			{	
			switch(type)
			{
			case "0" :
					var newLine = document.createElementNS(svgns,"line");
					newLine.setAttribute("x1", this.x0);
					newLine.setAttribute("y1", this.y0);
					newLine.setAttribute("x2", this.x1);
					newLine.setAttribute("y2", this.y1);
					newLine.setAttribute("stroke", this.color);
					newLine.setAttribute("stroke-width", this.sizeLine);
					svg.appendChild(newLine);
				break;
			case "1" :
				var newRect= document.createElementNS(svgns,'rect');
				var h = this.x1-this.x0;
				var w = this.y1-this.y0;
				if(w<0)
				{
					w*=-1;
				}
				if(h<0)
				{
					h*=-1;
				}
					newRect.setAttribute("x", this.x0);
					newRect.setAttribute("y", this.y0);
					newRect.setAttribute("height", w);
					newRect.setAttribute("width", h);
					newRect.setAttribute("stroke", this.color);
					newRect.setAttribute("stroke-width", this.sizeLine);
					svg.appendChild(newRect);
				break;
			case "2":
					var x = ((x1-x0)/2)+x0;
					var y = ((y1-y0)/2)+y0;
					var r = (y1-y0)/2;
					if(r<0)
					{
						r*=-1;
					}
					var newLine = document.createElementNS(svgns,"circle");
					newLine.setAttribute("cx", x);
					newLine.setAttribute("cy", y);
					newLine.setAttribute("r", r);
					
					newLine.setAttribute("stroke", this.color);
					newLine.setAttribute("stroke-width", this.sizeLine);
					svg.appendChild(newLine);
			break;
			}	
			}
		}
	function sizeL(val)
	{
		sizeLine  = val;
		return sizeLine;
	}
	function init() 
	{
	
		typeF = document.getElementById('box');
			
		svg.addEventListener('mousedown',function(ev)
		{
			setPosition_X_Y('down',ev);		
		});	
		svg.addEventListener('mousemove',function(ev)
		{
			setPosition_X_Y('move',ev);	
		});
		svg.addEventListener('mouseup',function(ev)
		{
				setPosition_X_Y('up',ev);	
		});
		svg.addEventListener('mouseout',function(ev)
		{
			setPosition_X_Y('out',ev);	
		});
	}
	function setPosition_X_Y(rez,ev)
	{
		if(rez=='down')
		{
			flag = true;
			prevX= ev.x - bound.left;
			prevY= ev.y - bound.top; 			
		}
		if(rez=='up')
		{
				flag = false;
				currentX= ev.x - bound.left;
				currentY= ev.y - bound.top;
				var figure = new PFigure(prevX, prevY, currentX, currentY, color,typeF.value, sizeLine);
				figures.push(figure);
				drawing();
		}
		if(rez=='move')
		{
			if(flag)
			{
			}
		}
	}
	
	function setColor(colorVal)
	{
		var  array = ["red","yellow","green","black","gray","blue"];
		color=array[colorVal];
		return color;
	}
   function drawing()
   {
	    for(var i = 0; i < figures.length; i++)
        {
            figures[i].draw();
		}		
   }
