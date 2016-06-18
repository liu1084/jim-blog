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

describe('format', function() {
  var formatFilter;

  beforeEach(module('ui.filters'));
  beforeEach(inject(function($filter) {
    formatFilter = $filter('format');
  }));

  it('should replace all instances of $0 if string token is passed', function() {
    expect(formatFilter('First $0, then $0, finally $0', 'bob')).toEqual('First bob, then bob, finally bob');
  });
  it('should replace all instances of $n based on order of token array', function() {
    expect(formatFilter('First is $0, then $1, finally $2', ['bob','frank','dianne'])).toEqual('First is bob, then frank, finally dianne');
  });
  it('should replace all instances :tokens based on keys of token object', function() {
    expect(formatFilter('First is :first, next is :second, finally there is :third', {first:'bob',second:'frank',third:'dianne'})).toEqual('First is bob, next is frank, finally there is dianne');
  });
  it('should do nothing if tokens are undefined', function() {
    expect(formatFilter('Hello There')).toEqual('Hello There');
  });
});