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

angular.module('ui.directives').directive('uiTemplate', ['ui.config', function (uiConfig) {
  var options = uiConfig.uiTemplate || {};
  return {
    restrict: 'EAC', // supports using directive as element, attribute and class
    link: function (iScope, iElement, iAttrs, controller) {
      var opts;

      // opts is link element-specific options merged on top of global defaults. If you only extend the global default, then all instances would override each other
      opts = angular.extend({}, options, iAttrs.uiTemplate);

      // your logic goes here
    }
  };
}]);


angular.module('ui.filters').filter('filterTmpl', ['ui.config', function (uiConfig) {
  return function (value) {
    return value;
  };
}]);