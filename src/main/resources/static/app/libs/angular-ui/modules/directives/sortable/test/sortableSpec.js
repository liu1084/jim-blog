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

describe('uiSortable', function() {

  // Ensure the sortable angular module is loaded
  beforeEach(module('ui.directives'));

  describe('simple use', function() {

    it('should have a ui-sortable class', function() {
      inject(function($compile, $rootScope) {
        var element;
        element = $compile("<ul ui-sortable></ul>")($rootScope);
        expect(element.hasClass("ui-sortable")).toBeTruthy();
      });
    });

    it('should update model when order changes', function() {
      inject(function($compile, $rootScope) {
        var element;
        element = $compile('<ul ui-sortable ng-model="items"><li ng-repeat="item in items" id="s-{{$index}}">{{ item }}</li></ul>')($rootScope);
        $rootScope.$apply(function() {
          return $rootScope.items = ["One", "Two", "Three"];
        });

        element.find('li:eq(1)').insertAfter(element.find('li:eq(2)'));

        // None of this work, one way is to use .bind("sortupdate")
        // and then use .trigger("sortupdate", e, ui) but I have no idea how to
        // construct ui object
        
        // element.sortable('refresh')
        // element.sortable('refreshPositions')
        // element.trigger('sortupdate')

        // expect($rootScope.items).toEqual(["One", "Three", "Two"])
      });
    });

  });

});