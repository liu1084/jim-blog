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

describe('unique', function () {
  var uniqueFilter;

  beforeEach(module('ui.filters'));
  beforeEach(inject(function ($filter) {
    uniqueFilter = $filter('unique');
  }));

  it('should return unique entries based on object equality', function () {
    var arrayToFilter = [
      {key: 'value'},
      {key: 'value2'},
      {key: 'value'}
    ];
    expect(uniqueFilter(arrayToFilter)).toEqual([
      {key: 'value'},
      {key: 'value2'}
    ]);
  });

  it('should return unique entries based on object equality for complex objects', function () {
    var arrayToFilter = [
      {key: 'value', other: 'other1'},
      {key: 'value2', other: 'other2'},
      {other: 'other1', key: 'value'}
    ];
    expect(uniqueFilter(arrayToFilter)).toEqual([
      {key: 'value', other: 'other1'},
      {key: 'value2', other: 'other2'}
    ]);
  });

  it('should return unique entries based on the key provided', function () {
    var arrayToFilter = [
      {key: 'value'},
      {key: 'value2'},
      {key: 'value'}
    ];
    expect(uniqueFilter(arrayToFilter, 'key')).toEqual([
      {key: 'value'},
      {key: 'value2'}
    ]);
  });

  it('should return unique entries based on the key provided for complex objects', function () {
    var arrayToFilter = [
      {key: 'value', other: 'other1'},
      {key: 'value2', other: 'other2'},
      {key: 'value', other: 'other3'}
    ];
    expect(uniqueFilter(arrayToFilter, 'key')).toEqual([
      { key: 'value', other: 'other1' },
      { key: 'value2', other: 'other2' }
    ]);
  });

  it('should return unique primitives in arrays', function () {
    expect(uniqueFilter([1, 2, 1, 3])).toEqual([1, 2, 3]);
  });

  it('should work correctly for arrays of mixed elements and object equality', function () {
    expect(uniqueFilter([1, {key: 'value'}, 1, {key: 'value'}, 2, "string", 3])).toEqual([1, {key: 'value'}, 2, "string", 3]);
  });

  it('should work correctly for arrays of mixed elements and a key specified', function () {
    expect(uniqueFilter([1, {key: 'value'}, 1, {key: 'value'}, 2, "string", 3], 'key')).toEqual([1, {key: 'value'}, 2, "string", 3]);
  });

  it('should return unmodified object if not array', function () {
    expect(uniqueFilter('string', 'someKey')).toEqual('string');
  });

  it('should return unmodified array if provided key === false', function () {
    var arrayToFilter = [
      {key: 'value1'},
      {key: 'value2'}
    ];
    expect(uniqueFilter(arrayToFilter, false)).toEqual(arrayToFilter);
  });

});