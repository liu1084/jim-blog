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

describe('uiKeyup', function () {

  var $scope, $compile;

  var createKeyEvent = function (mainKey, alt, ctrl, shif) {
    var keyEvent = jQuery.Event("keyup");

    keyEvent.keyCode = mainKey;
    keyEvent.altKey = alt || false;
    keyEvent.ctrlKey = ctrl || false;
    keyEvent.shiftKey = shif || false;

    return keyEvent;
  };

  var createElement = function (elementDef) {
    var elementStr = angular.isString(elementDef) ? elementDef : angular.toJson(elementDef);
    return $compile("<span ui-keyup='" + elementStr + "'></span>")($scope);
  };

  beforeEach(module('ui.directives'));
  beforeEach(inject(function (_$rootScope_, _$compile_) {
    $compile = _$compile_;
    $scope = _$rootScope_.$new();

    $scope.cb = function (event) {
      this.event1 = event;
    };
  }));

  it('should support single key press', function () {
    createElement({'13': 'event=true'}).trigger(createKeyEvent(13));
    expect($scope.event).toBe(true);
  });

  it('should support combined key press', function () {
    createElement({'ctrl-shift-13': 'event=true'}).trigger(createKeyEvent(13, false, true, true));
    expect($scope.event).toBe(true);
  });
  
  it('should support alternative combinations', function () {
    $scope.event = 0;
    createElement({'ctrl-shift-14 ctrl-shift-13': 'event=event+1'}).trigger(createKeyEvent(13, false, true, true)).trigger(createKeyEvent(14, false, true, true));
    expect($scope.event).toBe(2);
  });

  it('should support multiple key press definitions', function () {
    var elm = createElement({'13': 'event1=true', 'ctrl-shift-13': 'event2=true'});

    elm.trigger(createKeyEvent(13));
    expect($scope.event1).toBe(true);

    elm.trigger(createKeyEvent(13, false, true, true));
    expect($scope.event2).toBe(true);
  });

  it('should support $event in expressions', function () {

    var element = createElement({'esc': 'cb($event)', '13': 'event2=$event'});

    element.trigger(createKeyEvent(27));
    expect($scope.event1.keyCode).toBe(27);

    element.trigger(createKeyEvent(13));
    expect($scope.event2.keyCode).toBe(13);
  });
});