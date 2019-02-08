$("#button").click(function(){
        $.ajax('/hr2', {
            data:{department: $("#name").val()}
        }).done(function(json){
            $('#title').text(json.last_name);
            $('#number').text(json.salary);
        });
    });