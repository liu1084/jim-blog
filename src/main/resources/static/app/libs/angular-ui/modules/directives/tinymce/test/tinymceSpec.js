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

/*global describe, beforeEach, module, inject, it, spyOn, expect, $, angular, afterEach, runs, waits */
describe('uiTinymce', function () {
  'use strict';

  var scope, $compile, element, text = '<p>Hello</p>';
  beforeEach(module('ui'));
  beforeEach(function () {
    // throw some garbage in the tinymce cfg to be sure it's getting thru to the directive
    angular.module('ui.config').value('ui.config', {tinymce: {bar: 'baz'}});
  });
  beforeEach(inject(function (_$rootScope_, _$compile_) {
    scope = _$rootScope_.$new();
    $compile = _$compile_;
  }));

  afterEach(function () {
    angular.module('ui.config').value('ui.config', {}); // cleanup
  });

  /**
   * Asynchronously runs the compilation.
   */
  function compile() {
    runs(function () {
      element = $compile('<form><textarea name="foo" ui-tinymce="{foo: \'bar\'}" ng-model="foo"></textarea></form>')(scope);
    });
    waits(1);
  }

  describe('compiling this directive', function () {

    it('should include the passed options', function () {
      spyOn($.fn, 'tinymce');
      compile();
      runs(function () {
        expect($.fn.tinymce).toHaveBeenCalled();
        expect($.fn.tinymce.mostRecentCall.args[0].foo).toEqual('bar');
      });
    });

    it('should include the default options', function () {
      spyOn($.fn, 'tinymce');
      compile();
      runs(function () {
        expect($.fn.tinymce).toHaveBeenCalled();
        expect($.fn.tinymce.mostRecentCall.args[0].bar).toEqual('baz');
      });
    });
  });
  /*
  describe('setting a value to the model', function () {
    it('should update the editor', function() {
      compile();
      runs(function () {
        scope.$apply(function() {
          scope.foo = text;
        });
        expect(element.find('textarea').tinymce().getContent()).toEqual(text);
      });
    });
    it('should handle undefined gracefully', function() {
      compile();
      runs(function () {
        scope.$apply(function() {
          scope.foo = undefined;
        });
        expect(element.find('textarea').tinymce().getContent()).toEqual('');
      });
    });
    it('should handle null gracefully', function() {
      compile();
      runs(function () {
        scope.$apply(function() {
          scope.foo = null;
        });
        expect(element.find('textarea').tinymce().getContent()).toEqual('');
      });
    });
  });
  describe('using the editor', function () {
    it('should update the model', function() {
      compile();
      runs(function () {
        element.find('textarea').tinymce().setContent(text);
        expect($rootScope.x).toEqual(text);
      });
    });
  });
   */
});