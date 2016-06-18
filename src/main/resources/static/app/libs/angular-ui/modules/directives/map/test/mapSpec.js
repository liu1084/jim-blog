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

xdescribe('uiMap', function () {
  var scope, $rootScope, $compile;

  beforeEach(module('ui.directives'));
  beforeEach(inject(function (_$compile_, _$rootScope_) {
    $rootScope = _$rootScope_;
    $compile = _$compile_;
  }));

  function createMap(options, events) {
    scope.gmapOptions = options || {};
    scope.gmapEvents = events || {};
    $compile("<div ui-map='gmap' ui-options='gmapOptions'" +
      "' ui-event='gmapEvents'></div>")(scope);
  }

  function createWindow(options, events, inner) {
    scope.gOptions = options || {};
    scope.gEvents = events || {};
    inner = inner || angular.element('');
    var elm = angular.element("<div ui-map-info-window='ginfo' " +
      "ui-options='gOptions' ui-event='gEvents'></div>");
    elm.append(inner);
    $compile(elm)(scope);
  }

  describe('test', function () {
    beforeEach(function () {
      scope = $rootScope.$new();
    });

    it('should bind google map object to scope', function () {
      createMap();
      expect(scope.gmap).toBeTruthy();
    });

    it('should create google map with given options', function () {
      var center = new google.maps.LatLng(40, 40);
      createMap({center: center});
      expect(scope.gmap.getCenter()).toBe(center);
    });

    it('should pass events to the element as "map-eventname"', function () {
      scope.zoomy = false;
      scope.county = 0;
      createMap({}, {
        'map-zoom_changed': 'zoomy = true',
        'map-dblclick map-dragend': 'county = county + 1'
      });
      google.maps.event.trigger(scope.gmap, 'zoom_changed');
      expect(scope.zoomy).toBeTruthy();
      google.maps.event.trigger(scope.gmap, 'dblclick');
      expect(scope.county).toBe(1);
      google.maps.event.trigger(scope.gmap, 'dragend');
      expect(scope.county).toBe(2);
    });
  });

  describe('test infoWindow', function () {
    beforeEach(function () {
      scope = $rootScope.$new();
    });

    it('should bind info window to scope', function () {
      createWindow();
      expect(scope.ginfo).toBeTruthy();
    });

    it('should create info window with given options & content', function () {
      var content = $('<h1>Hi</h1>');
      createWindow({ zIndex: 5 }, {}, content);
      expect(scope.ginfo.getZIndex()).toBe(5);
      expect(scope.ginfo.getContent().innerHTML)
        .toBe($('<div>').append(content).html());
    });

    it('should $compile content and recognize scope changes', function () {
      var inner = $('<input ng-model="myVal">');
      createWindow({}, {}, inner);
      createMap();
      scope.$apply(function () {
        scope.myVal = 'initial';
      });
      scope.ginfo.open(scope.gmap, scope.gmap.getCenter());
      expect(inner.val()).toBe('initial');
      scope.$apply(function () {
        scope.myVal = 'final';
      });
      expect(inner.val()).toBe('final');
    });

    it('should recognize infowindow events in ui-event as "map-eventname"', function () {
      createWindow({}, {
        'map-closeclick': 'closed = true'
      });
      createMap();
      google.maps.event.trigger(scope.ginfo, 'closeclick');
      expect(scope.closed).toBe(true);
    });
  });

});