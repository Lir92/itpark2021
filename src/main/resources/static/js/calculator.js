$(function () {
    $('#calculate').click(function () {
        let arg1 = $('#arg1').val();
        let arg2 = $('#arg2').val();
        if (!arg1) {
            $('#arg1').css("border-color", "red")
        } else {
            $('#arg1').css("border-color", "")
        }

        if (!arg2) {
            $('#arg2').css("border-color", "red")
        } else {
            $('#arg2').css("border-color", "")
        }

        if (!arg1 || !arg2) {
            alert('Please input numbers to calculate')
            return;
        }

        $.ajax({
           url: '/calculator/sum?arg1=' + arg1 + '&arg2=' + arg2,
           type: 'POST',
           success: function (result) {
                    if (result.value) {
                        $('#result').text('Result of sum: ' + result.value)
                    }
           }
        });
    })
});