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

describe('highlight', function () {
  var highlightFilter, testPhrase = 'Prefix Highlight Suffix';

  beforeEach(module('ui.filters'));
  beforeEach(inject(function ($filter) {
    highlightFilter = $filter('highlight');
  }));
  describe('case insensitive', function () {
    it('should highlight a matching phrase', function () {
      expect(highlightFilter(testPhrase, 'highlight')).toEqual('Prefix <span class="ui-match">Highlight</span> Suffix');
    });
    it('should highlight nothing if no match found', function () {
      expect(highlightFilter(testPhrase, 'no match')).toEqual(testPhrase);
    });
    it('should highlight nothing for the undefined filter', function () {
      expect(highlightFilter(testPhrase, undefined)).toEqual(testPhrase);
    });
    it('should work correctly for number filters', function () {
      expect(highlightFilter('3210123', 0)).toEqual('321<span class="ui-match">0</span>123');
    });
    it('should work correctly for number text', function () {
      expect(highlightFilter(3210123, '0')).toEqual('321<span class="ui-match">0</span>123');
    });
  });
  describe('case sensitive', function () {
    it('should highlight a matching phrase', function () {
      expect(highlightFilter(testPhrase, 'Highlight', true)).toEqual('Prefix <span class="ui-match">Highlight</span> Suffix');
    });
    it('should highlight nothing if no match found', function () {
      expect(highlightFilter(testPhrase, 'no match', true)).toEqual(testPhrase);
    });
    it('should highlight nothing for the undefined filter', function () {
      expect(highlightFilter(testPhrase, undefined, true)).toEqual(testPhrase);
    });
    it('should work correctly for number filters', function () {
      expect(highlightFilter('3210123', 0, true)).toEqual('321<span class="ui-match">0</span>123');
    });
    it('should work correctly for number text', function () {
      expect(highlightFilter(3210123, '0', true)).toEqual('321<span class="ui-match">0</span>123');
    });
    it('should not highlight a phrase with different letter-casing', function () {
      expect(highlightFilter(testPhrase, 'highlight', true)).toEqual(testPhrase);
    });
  });
  it('should highlight nothing if empty filter string passed - issue #114', function () {
    expect(highlightFilter(testPhrase, '')).toEqual(testPhrase);
  });
});