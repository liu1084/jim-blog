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

/*
 * sample unit testing for sample templates and implementations
 */
describe('uiAnimate', function () {

  // declare these up here to be global to all tests
  var $rootScope, $compile, $timeout, uiConfig = angular.module('ui.config');

  beforeEach(module('ui.directives'));

  // inject in angular constructs. Injector knows about leading/trailing underscores and does the right thing
  // otherwise, you would need to inject these into each test
  beforeEach(inject(function (_$rootScope_, _$compile_, _$timeout_) {
    $rootScope = _$rootScope_;
    $compile = _$compile_;
    $timeout = _$timeout_;
  }));

  afterEach(function () {
    uiConfig.value('ui.config', {});
  });

  describe('behavior', function () {
    it('should add a ui-animate class when the dom is compiled', function () {
      var element = $compile('<div ui-animate></div>')($rootScope);
      expect(element.hasClass('ui-animate')).toBeTruthy();
    });
    it('should remove the ui-animate class immediately after injection', function () {
      var element = $compile('<div ui-animate></div>')($rootScope);
      $timeout.flush();
      expect(element.hasClass('ui-animate')).toBeFalsy();
    });

  });

  describe('options', function () {
    describe('passed', function () {

      it('should use a string as the class', function () {
        var element = $compile('<div ui-animate=" \'ui-hide\' "></div>')($rootScope);
        expect(element.hasClass('ui-hide')).toBeTruthy();
      });
      it('should use an object\'s class attribute as the class', function () {
        var element = $compile('<div ui-animate=" { \'class\' : \'ui-hide\' } "></div>')($rootScope);
        expect(element.hasClass('ui-hide')).toBeTruthy();
      });

    });
    describe('global', function () {

      var uiConfig;
      beforeEach(inject(function ($injector) {
        uiConfig = $injector.get('ui.config');
      }));

      it('should use a string as the class', function () {
        uiConfig.animate = 'ui-hide-global';
        var element = $compile('<div ui-animate></div>')($rootScope);
        expect(element.hasClass('ui-hide-global')).toBeTruthy();
      });

      it('should use an object\'s class attribute as the class', function () {
        uiConfig.animate = { 'class': 'ui-hide-global' };
        var element = $compile('<div ui-animate></div>')($rootScope);
        expect(element.hasClass('ui-hide-global')).toBeTruthy();
      });

    });
  });

});
