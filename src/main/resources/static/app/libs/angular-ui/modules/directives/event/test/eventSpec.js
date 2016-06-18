/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Jim Liu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

describe('uiEvent', function () {
  var $scope, $rootScope, $compile;

  beforeEach(module('ui.directives'));
  beforeEach(inject(function (_$rootScope_, _$compile_) {
    $compile = _$compile_;
    $rootScope = _$rootScope_;
  }));

  //helper for creating event elements
  function eventElement(scope, eventObject) {
    scope._uiEvent = eventObject || {};
    return $compile('<span ui-event="_uiEvent">')(scope);
  }

  describe('test', function () {
    it('should work with dblclick event and assignment', function () {
      $scope = $rootScope.$new();
      var elm = eventElement($scope, {'dblclick': 'dbl=true'});
      expect($scope.dbl).toBeUndefined();
      elm.trigger('dblclick');
      expect($scope.dbl).toBe(true);
    });

    it('should work with two events in one key a function', function () {
      $scope = $rootScope.$new();
      $scope.counter = 0;
      $scope.myfn = function () {
        $scope.counter++;
      };
      var elm = eventElement($scope, {'keyup mouseenter': 'myfn()'});
      elm.trigger('keyup');
      elm.trigger('mouseenter');
      expect($scope.counter).toBe(2);
    });

    it('should work work with multiple entries', function () {
      $scope = $rootScope.$new();
      $scope.amount = 5;
      var elm = eventElement($scope, {
        'click': 'amount=amount*2',
        'mouseenter': 'amount=amount*4',
        'keyup': 'amount=amount*3'
      });
      elm.trigger('click');
      expect($scope.amount).toBe(10);
      elm.trigger('mouseenter');
      expect($scope.amount).toBe(40);
      elm.trigger('keyup');
      expect($scope.amount).toBe(120);
    });

    it('should allow passing of $event object', function () {
      $scope = $rootScope.$new();
      $scope.clicky = function (par1, $event, par2) {
        expect($event.foo).toBe('bar');
        expect(par1).toBe(1);
        expect(par2).toBe(2);
      };
      var elm = eventElement($scope, {'click': 'clicky(1, $event, 2)'});
      $(elm).trigger({
        type: 'click',
        foo: 'bar'
      });
    });

    it('should allow passing of $params object', function () {
      $scope = $rootScope.$new();
      $scope.onStuff = function ($event, $params) {
        expect($event.type).toBe('stuff');
        expect($params[0]).toBe('foo');
        expect($params[1]).toBe('bar');
      };
      var elm = eventElement($scope, {'stuff': 'onStuff($event, $params)'});
      $(elm).trigger('stuff', ['foo', 'bar']);
    });
  });

});