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
describe('uiTemplate', function () {

  // declare these up here to be global to all tests
  var $rootScope, $compile;

  beforeEach(module('ui.directives'));
  beforeEach(module('ui.filters'));

  // inject in angular constructs. Injector knows about leading/trailing underscores and does the right thing
  // otherwise, you would need to inject these into each test
  beforeEach(inject(function (_$rootScope_, _$compile_) {
    $rootScope = _$rootScope_;
    $compile = _$compile_;
  }));

  // reset the ui.config after each test
  afterEach(function () {
    angular.module('ui.config').value('ui.config', {});
  });

  // optional grouping of tests
  describe('filter', function () {

    // we're doing filter tests so globally define here for this subset of tests
    var $filter;
    beforeEach(inject(function (_$filter_) {
      $filter = _$filter_;
    }));

    // very simple boilerplate setup of test for a custom filter
    var tmpl;
    beforeEach(function () {
      tmpl = $filter('filterTmpl');
    });

    it('should exist when provided', function () {
      expect(tmpl).toBeDefined();
    });

    it('should return exactly what interesting thing the filter is doing to input', function () {
      expect(tmpl('text')).toEqual('text');
    });

  });

  // optional grouping of tests
  describe('directive', function () {
    var element;
    it('should create an element if using element-style', function () {
      element = $compile('<ui-directive-tmpl ng-model="a"></ui-directive-tmpl>')($rootScope);
      expect(element).toBeDefined();
    });
  });

});
