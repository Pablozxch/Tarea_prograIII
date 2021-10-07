
package cr.ac.una.tareaprogra3.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cr.ac.una.tareaprogra3.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmpleadoAdmin_QNAME = new QName("http://websoap.una.ac.cr/", "EmpleadoAdmin");
    private final static QName _EmpleadoAdminResponse_QNAME = new QName("http://websoap.una.ac.cr/", "EmpleadoAdminResponse");
    private final static QName _EmpleadoFolio_QNAME = new QName("http://websoap.una.ac.cr/", "EmpleadoFolio");
    private final static QName _EmpleadoFolioResponse_QNAME = new QName("http://websoap.una.ac.cr/", "EmpleadoFolioResponse");
    private final static QName _RegistroFolio_QNAME = new QName("http://websoap.una.ac.cr/", "RegistroFolio");
    private final static QName _RegistroFolioResponse_QNAME = new QName("http://websoap.una.ac.cr/", "RegistroFolioResponse");
    private final static QName _RegistrosbyId_QNAME = new QName("http://websoap.una.ac.cr/", "RegistrosbyId");
    private final static QName _RegistrosbyIdResponse_QNAME = new QName("http://websoap.una.ac.cr/", "RegistrosbyIdResponse");
    private final static QName _SaveEmpleado_QNAME = new QName("http://websoap.una.ac.cr/", "SaveEmpleado");
    private final static QName _SaveEmpleadoResponse_QNAME = new QName("http://websoap.una.ac.cr/", "SaveEmpleadoResponse");
    private final static QName _SaveRegistro_QNAME = new QName("http://websoap.una.ac.cr/", "SaveRegistro");
    private final static QName _SaveRegistroResponse_QNAME = new QName("http://websoap.una.ac.cr/", "SaveRegistroResponse");
    private final static QName _DeleteEmpleado_QNAME = new QName("http://websoap.una.ac.cr/", "deleteEmpleado");
    private final static QName _DeleteEmpleadoResponse_QNAME = new QName("http://websoap.una.ac.cr/", "deleteEmpleadoResponse");
    private final static QName _DeleteRegistro_QNAME = new QName("http://websoap.una.ac.cr/", "deleteRegistro");
    private final static QName _DeleteRegistroResponse_QNAME = new QName("http://websoap.una.ac.cr/", "deleteRegistroResponse");
    private final static QName _GetRegistro_QNAME = new QName("http://websoap.una.ac.cr/", "getRegistro");
    private final static QName _GetRegistroResponse_QNAME = new QName("http://websoap.una.ac.cr/", "getRegistroResponse");
    private final static QName _JasP_QNAME = new QName("http://websoap.una.ac.cr/", "jasP");
    private final static QName _JasPEmp_QNAME = new QName("http://websoap.una.ac.cr/", "jasPEmp");
    private final static QName _JasPEmpResponse_QNAME = new QName("http://websoap.una.ac.cr/", "jasPEmpResponse");
    private final static QName _JasPFolio_QNAME = new QName("http://websoap.una.ac.cr/", "jasPFolio");
    private final static QName _JasPFolioResponse_QNAME = new QName("http://websoap.una.ac.cr/", "jasPFolioResponse");
    private final static QName _JasPResponse_QNAME = new QName("http://websoap.una.ac.cr/", "jasPResponse");
    private final static QName _Regtodo_QNAME = new QName("http://websoap.una.ac.cr/", "regtodo");
    private final static QName _RegtodoResponse_QNAME = new QName("http://websoap.una.ac.cr/", "regtodoResponse");
    private final static QName _JasPResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.tareaprogra3.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmpleadoAdmin }
     * 
     */
    public EmpleadoAdmin createEmpleadoAdmin() {
        return new EmpleadoAdmin();
    }

    /**
     * Create an instance of {@link EmpleadoAdminResponse }
     * 
     */
    public EmpleadoAdminResponse createEmpleadoAdminResponse() {
        return new EmpleadoAdminResponse();
    }

    /**
     * Create an instance of {@link EmpleadoFolio }
     * 
     */
    public EmpleadoFolio createEmpleadoFolio() {
        return new EmpleadoFolio();
    }

    /**
     * Create an instance of {@link EmpleadoFolioResponse }
     * 
     */
    public EmpleadoFolioResponse createEmpleadoFolioResponse() {
        return new EmpleadoFolioResponse();
    }

    /**
     * Create an instance of {@link RegistroFolio }
     * 
     */
    public RegistroFolio createRegistroFolio() {
        return new RegistroFolio();
    }

    /**
     * Create an instance of {@link RegistroFolioResponse }
     * 
     */
    public RegistroFolioResponse createRegistroFolioResponse() {
        return new RegistroFolioResponse();
    }

    /**
     * Create an instance of {@link RegistrosbyId }
     * 
     */
    public RegistrosbyId createRegistrosbyId() {
        return new RegistrosbyId();
    }

    /**
     * Create an instance of {@link RegistrosbyIdResponse }
     * 
     */
    public RegistrosbyIdResponse createRegistrosbyIdResponse() {
        return new RegistrosbyIdResponse();
    }

    /**
     * Create an instance of {@link SaveEmpleado }
     * 
     */
    public SaveEmpleado createSaveEmpleado() {
        return new SaveEmpleado();
    }

    /**
     * Create an instance of {@link SaveEmpleadoResponse }
     * 
     */
    public SaveEmpleadoResponse createSaveEmpleadoResponse() {
        return new SaveEmpleadoResponse();
    }

    /**
     * Create an instance of {@link SaveRegistro }
     * 
     */
    public SaveRegistro createSaveRegistro() {
        return new SaveRegistro();
    }

    /**
     * Create an instance of {@link SaveRegistroResponse }
     * 
     */
    public SaveRegistroResponse createSaveRegistroResponse() {
        return new SaveRegistroResponse();
    }

    /**
     * Create an instance of {@link DeleteEmpleado }
     * 
     */
    public DeleteEmpleado createDeleteEmpleado() {
        return new DeleteEmpleado();
    }

    /**
     * Create an instance of {@link DeleteEmpleadoResponse }
     * 
     */
    public DeleteEmpleadoResponse createDeleteEmpleadoResponse() {
        return new DeleteEmpleadoResponse();
    }

    /**
     * Create an instance of {@link DeleteRegistro }
     * 
     */
    public DeleteRegistro createDeleteRegistro() {
        return new DeleteRegistro();
    }

    /**
     * Create an instance of {@link DeleteRegistroResponse }
     * 
     */
    public DeleteRegistroResponse createDeleteRegistroResponse() {
        return new DeleteRegistroResponse();
    }

    /**
     * Create an instance of {@link GetRegistro }
     * 
     */
    public GetRegistro createGetRegistro() {
        return new GetRegistro();
    }

    /**
     * Create an instance of {@link GetRegistroResponse }
     * 
     */
    public GetRegistroResponse createGetRegistroResponse() {
        return new GetRegistroResponse();
    }

    /**
     * Create an instance of {@link JasP }
     * 
     */
    public JasP createJasP() {
        return new JasP();
    }

    /**
     * Create an instance of {@link JasPEmp }
     * 
     */
    public JasPEmp createJasPEmp() {
        return new JasPEmp();
    }

    /**
     * Create an instance of {@link JasPEmpResponse }
     * 
     */
    public JasPEmpResponse createJasPEmpResponse() {
        return new JasPEmpResponse();
    }

    /**
     * Create an instance of {@link JasPFolio }
     * 
     */
    public JasPFolio createJasPFolio() {
        return new JasPFolio();
    }

    /**
     * Create an instance of {@link JasPFolioResponse }
     * 
     */
    public JasPFolioResponse createJasPFolioResponse() {
        return new JasPFolioResponse();
    }

    /**
     * Create an instance of {@link JasPResponse }
     * 
     */
    public JasPResponse createJasPResponse() {
        return new JasPResponse();
    }

    /**
     * Create an instance of {@link Regtodo }
     * 
     */
    public Regtodo createRegtodo() {
        return new Regtodo();
    }

    /**
     * Create an instance of {@link RegtodoResponse }
     * 
     */
    public RegtodoResponse createRegtodoResponse() {
        return new RegtodoResponse();
    }

    /**
     * Create an instance of {@link EmpleadoDto }
     * 
     */
    public EmpleadoDto createEmpleadoDto() {
        return new EmpleadoDto();
    }

    /**
     * Create an instance of {@link RegistroDto }
     * 
     */
    public RegistroDto createRegistroDto() {
        return new RegistroDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpleadoAdmin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpleadoAdmin }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "EmpleadoAdmin")
    public JAXBElement<EmpleadoAdmin> createEmpleadoAdmin(EmpleadoAdmin value) {
        return new JAXBElement<EmpleadoAdmin>(_EmpleadoAdmin_QNAME, EmpleadoAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpleadoAdminResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpleadoAdminResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "EmpleadoAdminResponse")
    public JAXBElement<EmpleadoAdminResponse> createEmpleadoAdminResponse(EmpleadoAdminResponse value) {
        return new JAXBElement<EmpleadoAdminResponse>(_EmpleadoAdminResponse_QNAME, EmpleadoAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpleadoFolio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpleadoFolio }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "EmpleadoFolio")
    public JAXBElement<EmpleadoFolio> createEmpleadoFolio(EmpleadoFolio value) {
        return new JAXBElement<EmpleadoFolio>(_EmpleadoFolio_QNAME, EmpleadoFolio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpleadoFolioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpleadoFolioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "EmpleadoFolioResponse")
    public JAXBElement<EmpleadoFolioResponse> createEmpleadoFolioResponse(EmpleadoFolioResponse value) {
        return new JAXBElement<EmpleadoFolioResponse>(_EmpleadoFolioResponse_QNAME, EmpleadoFolioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroFolio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistroFolio }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "RegistroFolio")
    public JAXBElement<RegistroFolio> createRegistroFolio(RegistroFolio value) {
        return new JAXBElement<RegistroFolio>(_RegistroFolio_QNAME, RegistroFolio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroFolioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistroFolioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "RegistroFolioResponse")
    public JAXBElement<RegistroFolioResponse> createRegistroFolioResponse(RegistroFolioResponse value) {
        return new JAXBElement<RegistroFolioResponse>(_RegistroFolioResponse_QNAME, RegistroFolioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrosbyId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrosbyId }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "RegistrosbyId")
    public JAXBElement<RegistrosbyId> createRegistrosbyId(RegistrosbyId value) {
        return new JAXBElement<RegistrosbyId>(_RegistrosbyId_QNAME, RegistrosbyId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrosbyIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrosbyIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "RegistrosbyIdResponse")
    public JAXBElement<RegistrosbyIdResponse> createRegistrosbyIdResponse(RegistrosbyIdResponse value) {
        return new JAXBElement<RegistrosbyIdResponse>(_RegistrosbyIdResponse_QNAME, RegistrosbyIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveEmpleado }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveEmpleado }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "SaveEmpleado")
    public JAXBElement<SaveEmpleado> createSaveEmpleado(SaveEmpleado value) {
        return new JAXBElement<SaveEmpleado>(_SaveEmpleado_QNAME, SaveEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveEmpleadoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveEmpleadoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "SaveEmpleadoResponse")
    public JAXBElement<SaveEmpleadoResponse> createSaveEmpleadoResponse(SaveEmpleadoResponse value) {
        return new JAXBElement<SaveEmpleadoResponse>(_SaveEmpleadoResponse_QNAME, SaveEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRegistro }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveRegistro }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "SaveRegistro")
    public JAXBElement<SaveRegistro> createSaveRegistro(SaveRegistro value) {
        return new JAXBElement<SaveRegistro>(_SaveRegistro_QNAME, SaveRegistro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRegistroResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveRegistroResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "SaveRegistroResponse")
    public JAXBElement<SaveRegistroResponse> createSaveRegistroResponse(SaveRegistroResponse value) {
        return new JAXBElement<SaveRegistroResponse>(_SaveRegistroResponse_QNAME, SaveRegistroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmpleado }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmpleado }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "deleteEmpleado")
    public JAXBElement<DeleteEmpleado> createDeleteEmpleado(DeleteEmpleado value) {
        return new JAXBElement<DeleteEmpleado>(_DeleteEmpleado_QNAME, DeleteEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmpleadoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmpleadoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "deleteEmpleadoResponse")
    public JAXBElement<DeleteEmpleadoResponse> createDeleteEmpleadoResponse(DeleteEmpleadoResponse value) {
        return new JAXBElement<DeleteEmpleadoResponse>(_DeleteEmpleadoResponse_QNAME, DeleteEmpleadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRegistro }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteRegistro }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "deleteRegistro")
    public JAXBElement<DeleteRegistro> createDeleteRegistro(DeleteRegistro value) {
        return new JAXBElement<DeleteRegistro>(_DeleteRegistro_QNAME, DeleteRegistro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRegistroResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteRegistroResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "deleteRegistroResponse")
    public JAXBElement<DeleteRegistroResponse> createDeleteRegistroResponse(DeleteRegistroResponse value) {
        return new JAXBElement<DeleteRegistroResponse>(_DeleteRegistroResponse_QNAME, DeleteRegistroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRegistro }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRegistro }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "getRegistro")
    public JAXBElement<GetRegistro> createGetRegistro(GetRegistro value) {
        return new JAXBElement<GetRegistro>(_GetRegistro_QNAME, GetRegistro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRegistroResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRegistroResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "getRegistroResponse")
    public JAXBElement<GetRegistroResponse> createGetRegistroResponse(GetRegistroResponse value) {
        return new JAXBElement<GetRegistroResponse>(_GetRegistroResponse_QNAME, GetRegistroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JasP }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JasP }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "jasP")
    public JAXBElement<JasP> createJasP(JasP value) {
        return new JAXBElement<JasP>(_JasP_QNAME, JasP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JasPEmp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JasPEmp }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "jasPEmp")
    public JAXBElement<JasPEmp> createJasPEmp(JasPEmp value) {
        return new JAXBElement<JasPEmp>(_JasPEmp_QNAME, JasPEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JasPEmpResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JasPEmpResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "jasPEmpResponse")
    public JAXBElement<JasPEmpResponse> createJasPEmpResponse(JasPEmpResponse value) {
        return new JAXBElement<JasPEmpResponse>(_JasPEmpResponse_QNAME, JasPEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JasPFolio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JasPFolio }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "jasPFolio")
    public JAXBElement<JasPFolio> createJasPFolio(JasPFolio value) {
        return new JAXBElement<JasPFolio>(_JasPFolio_QNAME, JasPFolio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JasPFolioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JasPFolioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "jasPFolioResponse")
    public JAXBElement<JasPFolioResponse> createJasPFolioResponse(JasPFolioResponse value) {
        return new JAXBElement<JasPFolioResponse>(_JasPFolioResponse_QNAME, JasPFolioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JasPResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JasPResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "jasPResponse")
    public JAXBElement<JasPResponse> createJasPResponse(JasPResponse value) {
        return new JAXBElement<JasPResponse>(_JasPResponse_QNAME, JasPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Regtodo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Regtodo }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "regtodo")
    public JAXBElement<Regtodo> createRegtodo(Regtodo value) {
        return new JAXBElement<Regtodo>(_Regtodo_QNAME, Regtodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegtodoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegtodoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://websoap.una.ac.cr/", name = "regtodoResponse")
    public JAXBElement<RegtodoResponse> createRegtodoResponse(RegtodoResponse value) {
        return new JAXBElement<RegtodoResponse>(_RegtodoResponse_QNAME, RegtodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "return", scope = JasPResponse.class)
    public JAXBElement<byte[]> createJasPResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_JasPResponseReturn_QNAME, byte[].class, JasPResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "return", scope = JasPFolioResponse.class)
    public JAXBElement<byte[]> createJasPFolioResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_JasPResponseReturn_QNAME, byte[].class, JasPFolioResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "return", scope = JasPEmpResponse.class)
    public JAXBElement<byte[]> createJasPEmpResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_JasPResponseReturn_QNAME, byte[].class, JasPEmpResponse.class, ((byte[]) value));
    }

}
