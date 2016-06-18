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

/*global angular, $, document*/
/**
 * Adds a 'ui-scrollfix' class to the element when the page scrolls past it's position.
 * @param [offset] {int} optional Y-offset to override the detected offset.
 *   Takes 300 (absolute) or -300 or +300 (relative to detected)
 */
angular.module('ui.directives').directive('uiScrollfix', ['$window', function ($window) {
  'use strict';
  return {
    link: function (scope, elm, attrs) {
      var top = elm.offset().top;
      if (!attrs.uiScrollfix) {
        attrs.uiScrollfix = top;
      } else {
        // chartAt is generally faster than indexOf: http://jsperf.com/indexof-vs-chartat
        if (attrs.uiScrollfix.charAt(0) === '-') {
          attrs.uiScrollfix = top - attrs.uiScrollfix.substr(1);
        } else if (attrs.uiScrollfix.charAt(0) === '+') {
          attrs.uiScrollfix = top + parseFloat(attrs.uiScrollfix.substr(1));
        }
      }
      angular.element($window).on('scroll.ui-scrollfix', function () {
        // if pageYOffset is defined use it, otherwise use other crap for IE
        var offset;
        if (angular.isDefined($window.pageYOffset)) {
          offset = $window.pageYOffset;
        } else {
          var iebody = (document.compatMode && document.compatMode !== "BackCompat") ? document.documentElement : document.body;
          offset = iebody.scrollTop;
        }
        if (!elm.hasClass('ui-scrollfix') && offset > attrs.uiScrollfix) {
          elm.addClass('ui-scrollfix');
        } else if (elm.hasClass('ui-scrollfix') && offset < attrs.uiScrollfix) {
          elm.removeClass('ui-scrollfix');
        }
      });
    }
  };
}]);
