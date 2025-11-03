package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerDatosPrueba {

  private static final String RUTA_ARCHIVO_EXCEL = "src/test/resources/datosprueba/archivos/DatosPruebas.xlsx";

  public static <T> List<T> leerArchivoExcel(int hoja, Class<T> clase) {
    List<T> lista = new ArrayList<>();

    try (FileInputStream file = new FileInputStream(new File(RUTA_ARCHIVO_EXCEL));
        Workbook libroTrabajo = new XSSFWorkbook(file)) {

      Sheet hojaDatos = libroTrabajo.getSheetAt(hoja);

      for (Row fila : hojaDatos) {
        if (fila.getRowNum() == 0)
          continue; // Saltar encabezado

        int numeroColumnas = fila.getLastCellNum();
        if (numeroColumnas < 0)
          continue; // Saltar celdas vacias
        String[] valores = new String[numeroColumnas];

        for (int i = 0; i < numeroColumnas; i++) {
          Cell celda = fila.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
          celda.setCellType(CellType.STRING);
          valores[i] = celda.getStringCellValue().trim(); // Elimina espacios
        }

        // Validar si la fila está completamente vacía
        boolean filaVacia = Arrays.stream(valores).allMatch(String::isEmpty);
        if (filaVacia)
          continue;

        // Instanciar modelo usando el constructor con parámetros tipo String
        Constructor<T> constructor = clase.getConstructor(
            Arrays.stream(valores).map(v -> String.class).toArray(Class[]::new));
        T instancia = constructor.newInstance((Object[]) valores);

        lista.add(instancia);
      }

    } catch (Exception e) {
      System.err.println("Error al leer el archivo Excel: " + e.getMessage());
      e.printStackTrace();
    }

    return lista;
  }
}
