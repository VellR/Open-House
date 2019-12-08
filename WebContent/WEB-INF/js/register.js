function empty() {
    var formInputs = ["firstName", "lastName", "email", "username",
    	"password", "confirmPassword", "location", "birthday",
    	"phoneNumber"];
    
    for(var i = 0; i < formInputs.length; i++){
    	var input = document.getElementById(formInputs[i].value);
    	
    	if(input === ""){
    		return true;
    	}
    }
    
    return false;
}