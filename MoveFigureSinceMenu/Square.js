function  Square(x, y, width, height, type)
{
    var self               = this;
    var isDrawNestedSquare = false;
    const  sizeClick       = 25;
    self.type              = type;
    self.x                 = x;
    self.y                 = y;
    self.height            = height;
    self.width             = width;
    self.color             = '#000000';
    self.lineWidth         = 2;
    self.DrawNestedSquare  = function(posX, posY)
    {
        var result = false;

        if(((self.x <= posX)&&(posX <= self.x + self.width))&&((self.y <= posY)&&(posY <= self.y + self.height)))
        {
            result = true;
        }
        return result;
    };
    self.checkPosition = function (posX, posY)
    {
        var result = false;

        if(((self.x + sizeClick <= posX)&&(posX <= self.x + self.width - sizeClick))&&((self.y + sizeClick <= posY)&&(posY <= self.y + self.height - sizeClick)))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeLeftTopCorner= function (posX,  posY)
    {
        var result = false;

        if((self.x + sizeClick >= posX)&&(self.y + sizeClick >= posY)&&((posY >= self.y) && (posX >= self.x)))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeLeftSide= function (posX, posY)
    {
        var result = false;

        if((self.x + sizeClick >= posX)&&(self.y + self.height - sizeClick >= posY)&&((posY >= self.y) && (posX >= self.x)))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeLeftBottomCorner= function ( posX, posY)
    {
        var result = false;

        if((self.x + sizeClick >= posX)&&(self.y + self.height - sizeClick <= posY)&&((posY >= self.y) && (posX >= self.x)))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeBottomSide =  function ( posX,  posY)
    {
        var result = false;

        if((self.x + sizeClick <= posX)&&(self.x + self.width-sizeClick >= posX)&&(self.y + self.height - sizeClick <= posY)&&(posY <= self.y + self.height))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeRightBottomCorner=  function ( posX,  posY)
    {
        var result = false;

        if((self.x+self.width-sizeClick<=posX)&&(self.y+self.height-sizeClick<=posY)&&(posY <=self.y+self.height&&posX<=self.x+self.width))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeRightSide =  function (posX, posY)
    {
        var result = false;

        if((self.x + self.width - sizeClick <= posX)&&(self.y + self.height - sizeClick >= posY)&&(self.y + sizeClick <= posY)&&(posX <= self.x + self.width))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeRightTopCorner= function ( posX, posY)
    {
        var result = false;

        if((self.x + self.width - sizeClick <= posX)&&(self.y + sizeClick >= posY)&&((posY >= self.y) && (posX <= self.x + self.width)))
        {
            result = true;
        }
        return result;
    };
    self.checkSizeTopSide=  function ( posX,  posY)
    {
        var result = false;

        if((self.x + self.width - sizeClick >= posX)&&(self.x + sizeClick <= posX)&&(self.y + sizeClick >= posY)&&((posY >= self.y) && (posX >= self.x)))
        {
            result = true;
        }
        return result;
    };
////////////////////////////////////////////////////////////////////////////////////////////
    self.movePosition=  function ( posX, posY)
    {
        self.x      += posX;
        self.y      += posY;
    };
    self.moveSizeLeftTopCorner=  function ( posX,  posY)
    {
        self.x      -= posX;
        self.y      -= posY;
        self.width  += posX;
        self.height += posY;
    };
    self.moveSizeLeftSide= function ( posX,  posY)
    {
        self.x      -= posX;
        self.width  += posX;
    };
    self.moveSizeLeftBottomCorner=  function ( posX,  posY)
    {
        self.x      -= posX;
        self.width  += posX;
        self.height += posY;
    };
    self.moveSizeBottomSide= function ( posX,  posY)
    {
        self.height += posY;
    };
    self.moveSizeRightBottomCorner=  function ( posX,  posY)
    {
        self.width  += posX;
        self.height += posY;
    };
    self.moveSizeRightSide= function ( posX,  posY)
    {
        self.width  += posX;
    };
    self.moveSizeRightTopCorner=  function ( posX,  posY)
    {
        self.y      -= posY;
        self.width  += posX;
        self.height += posY;
    };
    self.moveSizeTopSide=function ( posX,  posY)
    {
        self.y      -= posY;
        self.height += posY;
    };
    self.CreateNastedSquare=function ()
    {
        var  RightTopBottomIntend =self.width/8;
        var  LeftTopBottomIntend=self.width/25;
        ctx.beginPath();
        ctx.fillStyle = "#00FF00";
        ctx.fillRect(self.x + LeftTopBottomIntend, self.y + LeftTopBottomIntend, self.width/10, self.width/10);
        ctx.fillRect(self.x + self.width/2,        self.y + LeftTopBottomIntend, self.width/10, self.width/10);
        ctx.fillRect(self.x + self.width- RightTopBottomIntend, self.y + LeftTopBottomIntend, self.width/10, self.width/10);
        ctx.fillRect(self.x + LeftTopBottomIntend, self.y + self.height/2, self.width/10,self.width/10);
        ctx.fillRect(self.x + self.width- RightTopBottomIntend, self.y + self.height/2, self.width/10, self.width/10);
        ctx.fillRect(self.x + LeftTopBottomIntend, self.y + self.height - RightTopBottomIntend, self.width/10, self.width/10);
        ctx.fillRect(self.x + self.width/2,        self.y + self.height - RightTopBottomIntend, self.width/10, self.width/10);
        ctx.fillRect(self.x + self.width- RightTopBottomIntend, self.y + self.height- RightTopBottomIntend, self.width/10,self.width/10);
        ctx.fill();
        ctx.closePath();
    };
    self.Draw = function ()
    {
        ctx.beginPath();
        ctx.lineWidth   = self.lineWidth;
        ctx.strokeStyle = self.color;
        switch(self.type)
        {
            case "1" :
                ctx.moveTo(self.x,self.y);
                ctx.lineTo(self.x + self.width,self.y + self.height);
                break;
            case "2":
                var x = ((self.width)/2)+self.x;
                var y = ((self.height)/2)+self.y;
                var r = (self.height)/2;
                if(r<0)
                {
                    r*=-1;
                }
                ctx.arc(x,y,r,0, Math.PI * 2, true);
                break;
            case "3" :
                ctx.strokeRect(self.x, self.y, self.width, self.height);
                break;

        }
        ctx.stroke();
        ctx.closePath();
    };
}
