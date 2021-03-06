package spark.deploy.client

/**
 * Callbacks invoked by deploy client when various events happen. There are currently four events:
 * connecting to the cluster, disconnecting, being given an executor, and having an executor
 * removed (either due to failure or due to revocation).
 *
 * Users of this API should *not* block inside the callback methods.
 */
private[spark] trait ClientListener {
  def connected(jobId: String): Unit

  def disconnected(): Unit

  def executorAdded(id: String, workerId: String, host: String, cores: Int, memory: Int): Unit

  def executorRemoved(id: String, message: String, exitStatus: Option[Int]): Unit
}
