import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

public class ParserPomXML {

    static String readMavenVariable(String propertyName)
    {
        Model model;
        FileReader reader;
        MavenXpp3Reader mavenReader = new MavenXpp3Reader();
        String propertyValue = "";
        try
        {
            reader = new FileReader("pom.xml");
            model = mavenReader.read(reader);
            MavenProject project = new MavenProject(model);
            while (project.getParent() != null)
            {
                project = project.getParent();
            }
            propertyValue = project.getProperties().getProperty(propertyName);
        }
        catch (IOException | XmlPullParserException ex)
        {
            System.err.println("Error reading pom.xml");
        }

        return propertyValue;
    }
}
