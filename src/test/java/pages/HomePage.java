package pages;

public class HomePage extends BasePage {

   
   
    private String homeTitulo = "//h5[@class='MuiTypography-root MuiTypography-h5 toolbar-title css-8u639']";
    private String sinTareas = "//div[@role='alert' and .//div[contains(text(),'No existen tareas para el usuario')]]";
    private String nuevaTareaBoton = "//button[.//text()[contains(.,'Nueva Tarea')]]";
    private String modalNuevaTarea = "//div[@role='dialog' and .//h2[normalize-space()='Crear nueva Tarea']]";
    private String cancelarNuevaTareaBoton = "//button[normalize-space()='Cancelar']";
    private String tabladeTareas= ("//tbody//a[contains(@class,'MuiTableRow-root')]");
    private String ordenarTitulo ="//th[.//text()[normalize-space()='Título']]//span[@role='button']";
    private String ordenadFechaVenc ="//th[.//text()[normalize-space()='Fecha Vencimiento']]//span[@role='button']";
    private String ordenarFechaCreacion ="//th[.//text()[normalize-space()='Fecha Creación']]//span[@role='button']";
    private String ordenarPrioridad ="//th[.//text()[normalize-space()='Prioridad']]//span[@role='button']";
    private String paginaAnterior = "//button[@aria-label='Go to previous page' and not(@disabled)]";
    private String paginaSiguiente = "//button[@aria-label='Go to next page' and not(@disabled)]";
    private String comboTareasPorPagina = "//div[@role='combobox']";
    private String opcionPorPagina = "//li[@role='option' and normalize-space()='%s']";
    private String filasTabla = "//tbody//a[contains(@class,'MuiTableRow-root')]";
    private String contadorRegistros = "//p[contains(@class,'MuiTablePagination-displayedRows')]";
    private String switchTablaCompact ="(//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-1jaw3da'])[1]";
    private String switchTablaCompacta="//label[.//span[text()='Tabla compacta']]//input[@type='checkbox']";
    

    




    



    public HomePage() {
        super();
    }


    

    public boolean isHomeVisible() {
        return isElementDisplayed(homeTitulo);
    }

    // Opcional (para Login_012)
    public boolean isSesionActiva() {
        return isElementDisplayed(homeTitulo);
    }

    public boolean isSinTareasVisible() {
        return isElementDisplayed(sinTareas);
    }

    public void clickNuevaTarea() {
        clickElement(nuevaTareaBoton);
    }
    public boolean isModalNuevaTareaVisible() {
        return isElementDisplayed(modalNuevaTarea);
    }

    public void clickCancelarNuevaTarea() {
        clickElement(cancelarNuevaTareaBoton);
    }

    public boolean existenTareas() {
        return tareasExistentes(tabladeTareas);
}
    public boolean modalNuevaTareaCerrado() {
        return !isElementDisplayed(modalNuevaTarea);
    }
    
    
    public boolean isOrdenTituloAsc() {
    return isElementPresent("//th[@aria-sort='ascending' and .//text()='Título']");
}

    public boolean isOrdenTituloDesc() {
    return isElementPresent("//th[@aria-sort='descending' and .//text()='Título']");
    }

    public void clickOrdenarPorTitulo() {
    clickElement(ordenarTitulo);
    }   

    public boolean isOrdenFechaAscCreacion(){
        return isElementPresent("//th[@aria-sort='ascending' and .//text()='Fecha Creación']");
    }

    public boolean isOrdenFechaAscVenc(){
        return isElementPresent("//th[@aria-sort='ascending' and .//text()='Fecha Vencimiento']");
    }

    public boolean isOrdenFechaDescVenc(){
        return isElementPresent("//th[@aria-sort='descending' and .//text()='Fecha Creación']");
    }

    public boolean isOrdenFechaDescCreacion(){
        return isElementPresent("//th[@aria-sort='descending' and .//text()='Fecha Vencimiento']");
    }

     public void clickOrdenarPorFechaCreacion() {
        clickElement(ordenadFechaVenc);
    }   
     public void clickOrdenarPorFechaCVencimiento() {
    clickElement(ordenarFechaCreacion);
    }


     public boolean isOrdenPrioridadAsc(){ 

        return isElementPresent("//th[@aria-sort='ascending' and .//text()='Prioridad']");
    }


    public boolean isOrdenPrioridadDesc(){
        return isElementPresent("//th[@aria-sort='descending' and .//text()='Prioridad']");
    }

      public void clickOrdenarPrioridad() {

        clickElement(ordenarPrioridad);
    }

    public void clickearPaginaSiguiente(){
        clickElement(paginaSiguiente);
    }
    
    public void clickearPaginaAnterior(){
        clickElement(paginaAnterior);
    }

    public void seleccionarTareasPorPagina(int cantidad) {
    clickElement(comboTareasPorPagina);

    String opcion = String.format(opcionPorPagina, cantidad);
    clickElement(opcion);
    }
    public int obtenerCantidadTareasVisibles() {
    return findElements(filasTabla).size();
    }
    public String obtenerTextoContador() {
    return getText(contadorRegistros);
    }


  public boolean isTablaCompactaActiva() {
    return Find(switchTablaCompact).isSelected();
}

public void activarTablaCompacta() {
    if (!isTablaCompactaActiva()) {
        clickElement(switchTablaCompact);
    }
}

public void desactivarTablaCompacta() {
    if (isTablaCompactaActiva()) {
        clickElement(switchTablaCompact);
    }
}

    



  
}





    
