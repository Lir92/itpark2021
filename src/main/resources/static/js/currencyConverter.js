$(function () {
    $('#convert').click(function () {
        let name = $('#name').val();
        let qtty = $('#qtty').val();
        if (!name) {
            $('#name').css("border-color", "red")
        } else {
            $('#name').css("border-color", "")
        }

        if (!qtty) {
            $('#qtty').css("border-color", "red")
        } else {
            $('#qtty').css("border-color", "")
        }

        if (!name || !qtty) {
            alert('Please input currency name or quantity to convert')
            return;
        }

        $.ajax({
            url: '/currencyConverter/convertCurrency?name=' + name + '&qtty=' + qtty,
            type: 'POST',
            success: function (result) {
                $('#result').text(qtty + ' ' + name + ' = ' + result.value + ' рублей')
            }
        });
    })
});