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

/*global describe, beforeEach, module, inject, it, spyOn, expect, $ */
describe('uiScrollfix', function () {
  'use strict';

  var scope, $compile, $window;
  beforeEach(module('ui.directives'));
  beforeEach(inject(function (_$rootScope_, _$compile_, _$window_) {
    scope = _$rootScope_.$new();
    $compile = _$compile_;
    $window = _$window_;
  }));

  describe('compiling this directive', function () {
    it('should bind to window "scroll" event with a ui-scrollfix namespace', function () {
      spyOn($.fn, 'on');
      $compile('<div ui-scrollfix="100"></div>')(scope);
      expect($.fn.on).toHaveBeenCalled();
      expect($.fn.on.mostRecentCall.args[0]).toBe('scroll.ui-scrollfix');
    });
  });
  describe('scrolling the window', function () {
    it('should add the ui-scrollfix class if the offset is greater than specified', function () {
      var element = $compile('<div ui-scrollfix="-100"></div>')(scope);
      $($window).trigger('scroll.ui-scrollfix');
      expect(element.hasClass('ui-scrollfix')).toBe(true);
    });
    it('should remove the ui-scrollfix class if the offset is less than specified (using absolute coord)', function () {
      var element = $compile('<div ui-scrollfix="100" class="ui-scrollfix"></div>')(scope);
      $($window).trigger('scroll.ui-scrollfix');
      expect(element.hasClass('ui-scrollfix')).toBe(false);

    });
    it('should remove the ui-scrollfix class if the offset is less than specified (using relative coord)', function () {
      var element = $compile('<div ui-scrollfix="+100" class="ui-scrollfix"></div>')(scope);
      $($window).trigger('scroll.ui-scrollfix');
      expect(element.hasClass('ui-scrollfix')).toBe(false);
    });
  });
});