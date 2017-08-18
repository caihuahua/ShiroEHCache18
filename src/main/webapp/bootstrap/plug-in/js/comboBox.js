(function ($) {
    //定义ComboBox的构造函数
    var ComboBox = function (ele, opt) {
        this.$element = ele;
        this.defaults = {
            data: [],
            url: '',
            value: '',
            text: '',
            prompt: '',
            onSelect: function () {
                return null;
            }
        };
        this.options = $.extend({}, this.defaults, opt)
    };

    //定义ComboBox的方法
    ComboBox.prototype = {
        loading: function () {
            var opts = this.options;
            var $ele = $(this.$element);
            $.ajax({
                async: false,
                url: opts.url,
                type: "POST",
                success: function (result) {
                    if (result != null) {
                        if (typeof (result) === 'string') {
                            try {
                                result = eval('(' + result + ')');
                            } catch (e) {
                                alert('后台返回数据格式不正确,请返回json格式!');
                            }
                        }
                        opts.data = result;
                        if (typeof (result) === 'object' && result.length > 0) {
                            var html = '';
                            if (opts.prompt) {
                                html = '<option value="">' + opts.prompt + '</option>';
                            }
                            $.each(result, function (index, row) {
                                if (row.selected) {
                                    html += '<option selected value="' + row[opts.value] + '">' + row[opts.text] + '</option>';
                                } else {
                                    html += '<option value="' + row[opts.value] + '">' + row[opts.text] + '</option>';
                                }
                            });
                            $ele.html(html);
                        }
                    }
                }
            });
        },
        loadingLocal: function () {
            var opts = this.options;
            var $ele = $(this.$element);
            var result = opts.data;
            if (typeof (result) === 'object' && result.length > 0) {
                var html = '';
                if (opts.prompt) {
                    html = '<option value="">' + opts.prompt + '</option>';
                }
                $.each(result, function (index, row) {
                    if (row.selected) {
                        html += '<option selected value="' + row[opts.value] + '">' + row[opts.text] + '</option>';
                    } else {
                        html += '<option value="' + row[opts.value] + '">' + row[opts.text] + '</option>';
                    }
                });
                $ele.html(html);
            }

        },
        onchange:function () {
            var opts = this.options;
            var $ele = $(this.$element);
            $ele.change(function () {
                var $option = $ele.find("option:selected");
                var index = $ele.get(0).selectedIndex;
                if (opts.prompt) index -= 1;
                opts.onSelect(index, $option, opts.data[index]);
            })
        },
        getData: function () {
            var opts = this.options;
            var index = $(this.$element).get(0).selectedIndex;
            if (opts.prompt) index -= 1;
            return opts.data[index];
        },
        getAllData: function () {
            return this.options.data;
        },
        getValue: function () {
            return $(this.$element).val();
        },
        getText: function () {
            return $(this.$element).find("option:selected").text();
        },
        setValue: function (param) {
            $(this.$element).val(param);
        }
    };

    //在插件中使用ComboBox对象
    $.fn.comboBox = function (options, param) {
        if (!options || $.isEmptyObject(options)) return;
        var $combo;

        function init() {
            if ($combo.options.data.length <= 0) {
                $combo.loading();
            } else {
                $combo.loadingLocal();
            }
            $combo.onchange();
        }

        if (typeof (options) === "object") {
            $combo = new ComboBox(this, options);
            $(this).data("ele", $combo);
            init();
        } else if (typeof (options) === "string") {
            $combo = $(this).data("ele");
            if (!$combo || $.isEmptyObject($combo)) return;
            if (options == "getData") {
                return $combo.getData();
            } else if (options == "getValue") {
                return $combo.getValue();
            } else if (options == "getText") {
                return $combo.getText();
            } else if (options == "getAllData") {
                return $combo.getAllData();
            } else if (options == "setValue") {
                $combo.setValue(param);
            }
        }
    };
})(jQuery);