package autenticarse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CredencialesModelo {

    private String nombreDeUsuario;
    private String contraseniaDeUsuario;
   
}
