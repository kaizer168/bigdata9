package org.apache.spark.sql.execution.datasources.v2

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.util.StringUtils
import org.apache.spark.sql.connector.catalog.CatalogV2Implicits.NamespaceHelper
import org.apache.spark.sql.connector.catalog.TableCatalog
import org.apache.spark.sql.execution.LeafExecNode

case class ShowVersionExec(
    output: Seq[Attribute],
    catalogManager: CatalogManager)
  extends LeafV2CommandExec {
  override protected def run(): Seq[InternalRow] = {
    Seq(util.Properties.versionString)
  }
}
