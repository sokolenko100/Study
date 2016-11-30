QUnit.test("Тест функции calc()", function(assert) 
 {
      assert.ok(calc(5,10,'+')==15,'Plus');
      assert.ok(calc(15,10,'-')==5,'Minus');
      assert.ok(calc(5,10,'*')==50,'Mult');
      assert.ok(calc(50,10,'/')==5,'Div');
});
/*QUnit.test("TEST function operation()", function(assert)
{
      assert.ok(operation('+')=='+','Plus');
      assert.ok(operation('-')=='-','Minus');
      assert.ok(operation('*')=='*','Mult');
      assert.ok(operation('/')=='/','Div');
});
QUnit.test("TEST function setnumb()", function(assert) 
{
      assert.ok(setnumb(10)==10,'ten');
      assert.ok(setnumb(0)==0,'zero');
      assert.ok(setnumb(-10)==-10,'M_ten');
});
QUnit.test("TEST function equal()", function(assert) 
{
      assert.ok(equal(5,10,'+')==15,'Plus');
      assert.ok(equal(15,10,'-')==5,'Minus');
      assert.ok(equal(5,10,'*')==50,'Mult');
      assert.ok(equal(50,10,'/')==5,'Div');
})*/