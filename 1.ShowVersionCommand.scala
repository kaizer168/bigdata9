ackage org.apache.spark.sql.execution.command

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.catalyst.expressions.{Attribute, AttributeReference}
import org.apache.spark.sql.types.StringType

case class ShowVersionCommand() extends LeafRunnableCommand {
  override val output: Seq[Attribute] = Seq(AttributeReference("version", StringType)())
  override def run(sparkSession: SparkSession): Seq[Row] = {
    val sparkVersion = sparkSession.version
    val javaVersion = System.getProperty("java.version")
    val output = "Spark Version: %s, Java Version: %s".format(sparkVersion, javaVersion)
    Seq(Row(output))
  }
}
