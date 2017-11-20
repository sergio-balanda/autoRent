# autoRent
taller web unlam

##
* nuevo sql

* ALQUILER deberia tener la sucursal de devolucion, porq reserva tiene la de retiro del vehiculo. Esto lo arranque pero lo deje por que 
    me parece q el orden del trello seria otro.

* cambio reserva modelo campo finalizada, se crea por defecto como false, y cuando el admin selecciona una reserva de la lista de reservas
    y preciona modificar esa reserva se da por finalizada y sale de las listas de reservas.
    
* vista de perfil de usuario, pensado para ver depues el tema de los puntos, y para que el usuario vea los puntos q tiene y que no nos diga como WebII
    para que muestran el nombre ahi si no hace nada, al hacer una reserva al usuario se le suma 500 puntos,
    pero en la vista detalle-usuario, que se ve haciendo click en nombre de usuario parte superior derecha una vez loqueado(un usuario comun, no admin), se ve su perfil con los puntos ojo q por locura de spring si hago una reserva y voy a la vista detalle-usuario no se ven cambios en
    los puntos hay que salir de la session y volver a entrar y ahi si se ven los cambios.
    
* convertir puntos a pesos cuando se ingresa comos admin en el detalle-reserva.(no terminado), en servicio reserva esta la logica.

###


