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

/*global beforeEach, describe, it, inject, expect, module, spyOn*/

(function () {
    'use strict';

    describe('uiShow', function () {

        var scope, $compile;
        beforeEach(module('ui.directives'));
        beforeEach(inject(function (_$rootScope_, _$compile_) {
            scope = _$rootScope_.$new();
            $compile = _$compile_;
        }));

        describe('linking the directive', function () {
            it('should call scope.$watch', function () {
                spyOn(scope, '$watch');
                $compile('<div ui-show="foo"></div>')(scope);
                expect(scope.$watch).toHaveBeenCalled();
            });
        });

        describe('executing the watcher', function () {
            it('should add the ui-show class if true', function () {
                var element = $compile('<div ui-show="foo"></div>')(scope);
                scope.foo = true;
                scope.$apply();
                expect(element.hasClass('ui-show')).toBe(true);
            });
            it('should remove the ui-show class if false', function () {
                var element = $compile('<div ui-show="foo"></div>')(scope);
                scope.foo = false;
                scope.$apply();
                expect(element.hasClass('ui-show')).toBe(false);
            });
        });
    });

    describe('uiHide', function () {

        var scope, $compile;
        beforeEach(module('ui.directives'));
        beforeEach(inject(function (_$rootScope_, _$compile_) {
            scope = _$rootScope_.$new();
            $compile = _$compile_;
        }));

        describe('when the directive is linked', function () {
            it('should call scope.$watch', function () {
                spyOn(scope, '$watch');
                $compile('<div ui-hide="foo"></div>')(scope);
                expect(scope.$watch).toHaveBeenCalled();
            });
        });

        describe('executing the watcher', function () {
            it('should add the ui-hide class if true', function () {
                var element = $compile('<div ui-hide="foo"></div>')(scope);
                scope.foo = true;
                scope.$apply();
                expect(element.hasClass('ui-hide')).toBe(true);
            });
            it('should remove the ui-hide class if false', function () {
                var element = $compile('<div ui-hide="foo"></div>')(scope);
                scope.foo = false;
                scope.$apply();
                expect(element.hasClass('ui-hide')).toBe(false);
            });
        });
    });

    describe('uiToggle', function () {

        var scope, $compile;
        beforeEach(module('ui.directives'));
        beforeEach(inject(function (_$rootScope_, _$compile_) {
            scope = _$rootScope_.$new();
            $compile = _$compile_;
        }));

        describe('when the directive is linked', function () {
            it('should call scope.$watch', function () {
                spyOn(scope, '$watch');
                $compile('<div ui-toggle="foo"></div>')(scope);
                expect(scope.$watch).toHaveBeenCalled();
            });
        });

        describe('executing the watcher', function () {
            it('should remove the ui-hide class and add the ui-show class if true', function () {
                var element = $compile('<div ui-toggle="foo"></div>')(scope);
                scope.foo = true;
                scope.$apply();
                expect(element.hasClass('ui-show') && !element.hasClass('ui-hide')).toBe(true);
            });
            it('should remove the ui-hide class and add the ui-show class if false', function () {
                var element = $compile('<div ui-toggle="foo"></div>')(scope);
                scope.foo = false;
                scope.$apply();
                expect(!element.hasClass('ui-show') && element.hasClass('ui-hide')).toBe(true);
            });
        });
    });
})();
