$(function () {
    $('#create').click(function () {


        $.ajax({
           url: '/api/accounts',
            headers: {
               'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
           type: 'POST',
            dataType: 'json',
            data: JSON.stringify({
                id: $('#id').val(),
                owner: $('#owner').val(),
                balance: $('#balance').val(),
            }),
           success: function () {
                    alert('Created successfully!')
           }
        });
    })
});