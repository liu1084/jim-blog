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

xdescribe('uiMask', function () {

  var inputHtml = "<input ui-mask=\"'(9)9'\" ng-model='x'>";
  var $compile, $rootScope, element;

  beforeEach(module('ui.directives'));
  beforeEach(inject(function (_$rootScope_, _$compile_) {
    $rootScope = _$rootScope_;
    $compile = _$compile_;
  }));

  describe('ui changes on model changes', function () {
    it('should update ui valid model value', function () {
      $rootScope.x = undefined;
      element = $compile(inputHtml)($rootScope);
      $rootScope.$digest();
      expect(element.val()).toBe('');
      $rootScope.$apply(function () {
        $rootScope.x = 12;
      });
      expect(element.val()).toBe('(1)2');
    });
    it('should wipe out ui on invalid model value', function () {
      $rootScope.x = 12;
      element = $compile(inputHtml)($rootScope);
      $rootScope.$digest();
      expect(element.val()).toBe('(1)2');
      $rootScope.$apply(function () {
        $rootScope.x = 1;
      });
      expect(element.val()).toBe('');
    });
  });

  describe('model binding on ui change', function () {
    //TODO: was having har time writing those tests, will open a separate issue for those
  });

  describe('should fail', function() {
    it('errors on missing quotes', function() {
      $rootScope.x = 42;
      var errorInputHtml = "<input ui-mask=\"(9)9\" ng-model='x'>";
      element = $compile(errorInputHtml)($rootScope);
      expect($rootScope.$digest).toThrow('The Mask widget is not correctly set up');
    });
  });
});