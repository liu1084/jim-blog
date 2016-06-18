
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


!function ($) {

  "use strict"; // jshint ;_;


  /* MODAL CLASS DEFINITION
   * ====================== */

  var Modal = function (content, options) {
    this.options = options;
    this.$element = $(content)
      .delegate('[data-dismiss="modal"]', 'click.dismiss.modal', $.proxy(this.hide, this))
  };

  Modal.prototype = {

    constructor: Modal, toggle: function () {
      return this[!this.isShown ? 'show' : 'hide']()
    }, show: function () {
      var that = this
        , e = $.Event('show')

      this.$element.trigger(e)

      if (this.isShown || e.isDefaultPrevented()) return

      $('body').addClass('modal-open')

      this.isShown = true

      escape.call(this)
      backdrop.call(this, function () {
        var transition = $.support.transition && that.$element.hasClass('fade')

        if (!that.$element.parent().length) {
          that.$element.appendTo(document.body) //don't move modals dom position
        }

        that.$element
          .show()

        if (transition) {
          that.$element[0].offsetWidth // force reflow
        }

        that.$element.addClass('in')

        transition ?
          that.$element.one($.support.transition.end, function () {
            that.$element.trigger('shown')
          }) :
          that.$element.trigger('shown')

      })
    }, hide: function (e) {
      e && e.preventDefault()

      var that = this

      e = $.Event('hide')

      this.$element.trigger(e)

      if (!this.isShown || e.isDefaultPrevented()) return

      this.isShown = false

      $('body').removeClass('modal-open')

      escape.call(this)

      this.$element.removeClass('in')

      $.support.transition && this.$element.hasClass('fade') ?
        hideWithTransition.call(this) :
        hideModal.call(this)
    }

  }


  /* MODAL PRIVATE METHODS
   * ===================== */

  function hideWithTransition() {
    var that = this
      , timeout = setTimeout(function () {
        that.$element.off($.support.transition.end)
        hideModal.call(that)
      }, 500)

    this.$element.one($.support.transition.end, function () {
      clearTimeout(timeout)
      hideModal.call(that)
    })
  }

  function hideModal(that) {
    this.$element
      .hide()
      .trigger('hidden')

    backdrop.call(this)
  }

  function backdrop(callback) {
    var that = this
      , animate = this.$element.hasClass('fade') ? 'fade' : ''

    if (this.isShown && this.options.backdrop) {
      var doAnimate = $.support.transition && animate

      this.$backdrop = $('<div class="modal-backdrop ' + animate + '" />')
        .appendTo(document.body)

      if (this.options.backdrop != 'static') {
        this.$backdrop.click($.proxy(this.hide, this))
      }

      if (doAnimate) this.$backdrop[0].offsetWidth // force reflow

      this.$backdrop.addClass('in')

      doAnimate ?
        this.$backdrop.one($.support.transition.end, callback) :
        callback()

    } else if (!this.isShown && this.$backdrop) {
      this.$backdrop.removeClass('in')

      $.support.transition && this.$element.hasClass('fade') ?
        this.$backdrop.one($.support.transition.end, $.proxy(removeBackdrop, this)) :
        removeBackdrop.call(this)

    } else if (callback) {
      callback()
    }
  }

  function removeBackdrop() {
    this.$backdrop.remove()
    this.$backdrop = null
  }

  function escape() {
    var that = this
    if (this.isShown && this.options.keyboard) {
      $(document).on('keyup.dismiss.modal', function (e) {
        e.which == 27 && that.hide()
      })
    } else if (!this.isShown) {
      $(document).off('keyup.dismiss.modal')
    }
  }


  /* MODAL PLUGIN DEFINITION
   * ======================= */

  $.fn.modal = function (option) {
    return this.each(function () {
      var $this = $(this)
        , data = $this.data('modal')
        , options = $.extend({}, $.fn.modal.defaults, $this.data(), typeof option == 'object' && option)
      if (!data) $this.data('modal', (data = new Modal(this, options)))
      if (typeof option == 'string') data[option]()
      else if (options.show) data.show()
    })
  }

  $.fn.modal.defaults = {
    backdrop: true, keyboard: true, show: true
  }

  $.fn.modal.Constructor = Modal


  /* MODAL DATA-API
   * ============== */

  $(function () {
    $('body').on('click.modal.data-api', '[data-toggle="modal"]', function (e) {
      var $this = $(this), href
        , $target = $($this.attr('data-target') || (href = $this.attr('href')) && href.replace(/.*(?=#[^\s]+$)/, '')) //strip for ie7
        , option = $target.data('modal') ? 'toggle' : $.extend({}, $target.data(), $this.data())

      e.preventDefault()
      $target.modal(option)
    })
  })

}(window.jQuery);