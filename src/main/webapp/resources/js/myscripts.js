$(document).ready(function(){

    $("#loginform").validate({
        
       rules:{ 
        
            firstname:{
                required: true,
                minlength: 4,
                maxlength: 16,
            },
            
            lastname:{
                required: true,
                minlength: 6,
                maxlength: 16,
            },
       },
       
       messages:{
        
            login:{
                required: "Это поле обязательно для заполнения",
                minlength: "Логин должен быть минимум 4 символа",
                maxlength: "Максимальное число символо - 16",
            },
            
            pswd:{
                required: "Это поле обязательно для заполнения",
                minlength: "Пароль должен быть минимум 6 символа",
                maxlength: "Максимальное число символо - 16",
            },
        
       }
        
    });


}); //end of ready