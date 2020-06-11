var index = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },
    save : function() {
        var data = {
            cardNo : $('#cardNo').val(),
            validYm : $('#validYm').val(),
            cvcNo : $('#cvcNo').val(),
            istmtAmt : $('#istmtAmt').val(),
            payAmt : $('#payAmt').val(),
            vatAmt : $('#vatAmt').val()
            // test reload
            // test reload 2
            // test reload 3
            // test reload 4
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/payments',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('결제정보가 저장되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            payAmt: $('#payAmt').val(),
            vatAmt: $('#vatAmt').val()
        };

        var payNo = $('#payNo').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/payments/' + payNo,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('결제가 취소되었습니다.');
            window.location.href = '/';
        }).fail(function() {
            alert(JSON.stringify(error));
        });


    }
};
index.init();