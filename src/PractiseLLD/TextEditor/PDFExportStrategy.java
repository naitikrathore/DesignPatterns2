package PractiseLLD.TextEditor;

public class PDFExportStrategy implements ExportStrategy{
    @Override
    public void export(Document document) {
        System.out.println("Pdf PDFExportStrategy");
    }
}
