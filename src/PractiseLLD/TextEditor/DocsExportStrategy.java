package PractiseLLD.TextEditor;

public class DocsExportStrategy implements ExportStrategy{
    @Override
    public void export(Document document) {
        System.out.println("Exporting Document " + document);
    }
}
