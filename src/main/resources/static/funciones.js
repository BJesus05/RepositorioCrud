function eliminar(id){
	swal({
  title: "Esta seguro eliminar",
  text: "Despues de elimnar no se puede regresar el registro",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	  $.ajax({	
		  url:"/eliminar/"+id,
	  		success: function(res){
		  		console.log(res);
		  				location.href="/listar";

	  		}
	  });
  } else {
    swal("Tu registro no se ha eliminado!");
  }
});
}

