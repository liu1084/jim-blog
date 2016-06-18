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

describe('inflector', function () {
  var inflectorFilter, testPhrase = 'here isMy_phone_number';

  beforeEach(module('ui.filters'));
  beforeEach(inject(function ($filter) {
    inflectorFilter = $filter('inflector');
  }));

  describe('default', function () {
    it('should default to humanize', function () {
      expect(inflectorFilter(testPhrase)).toEqual('Here Is My Phone Number');
    });
    it('should fail gracefully for invalid input', function () {
      expect(inflectorFilter(undefined)).toBeUndefined();
    });
    it('should do nothing for empty input', function () {
      expect(inflectorFilter('')).toEqual('');
    });
  });

  describe('humanize', function () {
    it('should uppercase first letter and separate words with a space', function () {
      expect(inflectorFilter(testPhrase, 'humanize')).toEqual('Here Is My Phone Number');
    });
  });
  describe('underscore', function () {
    it('should lowercase everything and separate words with an underscore', function () {
      expect(inflectorFilter(testPhrase, 'underscore')).toEqual('here_is_my_phone_number');
    });
  });
  describe('variable', function () {
    it('should remove all separators and camelHump the phrase', function () {
      expect(inflectorFilter(testPhrase, 'variable')).toEqual('hereIsMyPhoneNumber');
    });
    it('should do nothing if already formatted properly', function () {
      expect(inflectorFilter("hereIsMyPhoneNumber", 'variable')).toEqual('hereIsMyPhoneNumber');
    });
  });
});