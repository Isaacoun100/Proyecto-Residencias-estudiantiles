# Sistema de Gestión de Residencias

Este proyecto en Java gestiona una lista de residencias, sus apartamentos y los estudiantes asignados a cada apartamento en una institución. Se realizan validaciones para asegurar que los datos sean consistentes y se proporciona información detallada sobre las residencias, los apartamentos y los estudiantes.

## Funcionalidades

1. **Agregar Residencias**: Puedes agregar nuevas residencias al sistema.
   - Validación: No se permiten residencias repetidas.
   
2. **Agregar Apartamentos**: Se pueden agregar apartamentos a las residencias.
   - Validación: Un apartamento no puede pertenecer a más de una residencia.

3. **Agregar Estudiantes**: Los estudiantes pueden ser asignados a apartamentos.
   - Validaciones:
     - Un estudiante no puede estar en más de un apartamento.
     - El apartamento debe tener disponibilidad (máximo 5 estudiantes).

4. **Listar Información**:
   - **Lista de residencias**: Se muestra la lista de residencias, sus apartamentos y los estudiantes asignados.
   - **Lista de estudiantes**: Los estudiantes se listan en orden alfabético, mostrando el apartamento en el que están asignados.

## Validaciones del Sistema

- **Residencias**:
  - No se pueden agregar residencias con nombres duplicados.

- **Apartamentos**:
  - Los apartamentos no pueden estar registrados en más de una residencia.

- **Estudiantes**:
  - Se verifica que el estudiante no esté asignado a otro apartamento.
  - Se verifica que el apartamento no exceda el límite de 5 estudiantes.

## Requerimientos

- Java 8 o superior

## Ejecución del Proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Isaacoun100/Proyecto-Residencias-estudiantiles
