package modulo_pim.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioModelo {

  private String primerNombre;
  private String segundoNombre;
  private String apellido;

}
