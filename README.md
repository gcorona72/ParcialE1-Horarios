# **Gestión de Horarios Académicos**

**Descripción del Proyecto**  
Este proyecto es una aplicación Android diseñada para gestionar horarios académicos. Desarrollada utilizando **Kotlin**, **Jetpack Compose** y **ViewBinding**, la aplicación permite a los usuarios crear, consultar y gestionar horarios de asignaturas de manera sencilla y eficiente. Los usuarios pueden ingresar su horario de clases, visualizarlo por días y consultar la asignatura que está en curso según la hora y fecha actual.

## **Características Principales**

1. **Gestión de Horarios**  
   La aplicación permite a los usuarios crear un horario académico para sus asignaturas, donde pueden ingresar el nombre de la asignatura, el día de la semana y la hora. Esta funcionalidad es clave para mantener un registro organizado de las actividades académicas.

2. **Visualización del Horario Completo**  
   Una vez que los horarios están creados, los usuarios pueden acceder a una vista detallada de su horario completo, organizada por días de la semana. Esto facilita la consulta rápida del horario académico y la planificación diaria.

3. **Consulta Rápida**  
   Gracias a la funcionalidad de consulta rápida, los usuarios pueden ver la asignatura en curso en el momento actual, basándose en la hora y fecha del dispositivo. Esto es útil para saber qué clase está programada sin necesidad de buscar manualmente en el horario completo.

## **Estructura de la Aplicación**

### **MainActivity**
`MainActivity` es el punto de entrada de la aplicación. Esta clase gestiona la navegación entre los diferentes fragmentos de la aplicación mediante botones. Su principal responsabilidad es manejar la interacción del usuario para cambiar entre la creación de horarios y la visualización del horario completo.

### **CreateScheduleFragment**
El `CreateScheduleFragment` es un fragmento dedicado a la creación de horarios académicos. Permite a los usuarios introducir información sobre la asignatura, como el nombre de la asignatura, el día y la hora. Los datos ingresados se almacenan para ser utilizados posteriormente en la visualización del horario.

### **ViewScheduleFragment**
`ViewScheduleFragment` es el fragmento encargado de mostrar el horario académico completo. Los usuarios pueden consultar todos los horarios de asignaturas organizados por días de la semana. Este fragmento facilita la visualización de las clases programadas en un formato claro y estructurado.

### **Navegación entre Fragmentos**
La navegación entre fragmentos se maneja desde `MainActivity`, utilizando botones que permiten a los usuarios cambiar entre la creación de horarios y la vista del horario completo. Esto proporciona una experiencia de usuario fluida y sencilla.

## **Tecnologías Utilizadas**

- **Kotlin**: Lenguaje de programación utilizado para el desarrollo de la aplicación.
- **Jetpack Compose**: Framework moderno para la creación de interfaces de usuario nativas en Android.
- **ViewBinding**: Utilizado para acceder de manera segura a las vistas de los fragmentos y actividades.
- **Fragmentos**: Arquitectura basada en fragmentos para gestionar las diferentes vistas de la aplicación de manera modular.

## **Objetivo del Proyecto**

El principal objetivo de este proyecto es ofrecer una herramienta práctica para estudiantes y docentes, que facilite la gestión de horarios académicos de manera eficiente. Con su interfaz intuitiva y funcionalidades bien definidas, los usuarios pueden optimizar su tiempo y tener siempre a la mano la información relevante sobre sus clases.

## **Licencia**

Este proyecto está bajo la **Licencia MIT**, lo que permite la reutilización y modificación del código, siempre que se mantenga el aviso de autor y la licencia original.
